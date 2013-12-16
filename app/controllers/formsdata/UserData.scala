package controllers.formsdata

import models._
import play.api.data.Form
import play.api.data.Forms._
import models.repositories.UserRepository
import security.Authenticator

object UserData {

  val userCreateForm = Form(
    mapping(
      "login" -> nonEmptyText(1, 32) .verifying(
        "User with this login already exists!", user => !UserRepository.isLoginRegistered(user)
      ),
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> nonEmptyText(8, 16),
        "confirm" -> nonEmptyText(8, 16)
      ). verifying (
        "Password does not match it's confirmation", passwords => passwords._1 == passwords._2
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))

    )
    {
      (login,name,surname,passwords,role) => {
        {
          role match {
          case "S" => new Student(login,name,surname,Authenticator.cryptPassword(passwords._1))
          case "T" => new Teacher(login,name,surname,Authenticator.cryptPassword(passwords._1))
          case "H" => new Headmaster(login,name,surname,Authenticator.cryptPassword(passwords._1))
          case _ => new User(login,name,surname,Authenticator.cryptPassword(passwords._1))
          }
        }
      }
    }
    {
      user => Some(user.getLogin,user.getName,user.getSurname,("",""),user.getUserType)
    }
  )

  val userEditForm = Form(
    mapping(
      "id"  -> number . verifying (
        "User does not exist!", !UserRepository.findById(_).isEmpty
        ),
      "login" -> nonEmptyText(1, 32),
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> optional(nonEmptyText(8,32)),
        "confirm" -> optional(nonEmptyText(8, 32))
      ). verifying (
        "New password does not match it's confirmation", _ match {
          case (pass,confirm) if !pass.isEmpty || !confirm.isEmpty => pass == confirm
          case _ => true
        }
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))
    )
    {
      (id,login,name,surname,passwords,role) => {
        var user = UserRepository.findById(id).get
          user.setUser_id(id)
          user.setLogin(login)
          user.setName(name)
          user.setSurname(surname)
          user.setPassword(passwords._1 match {
            case Some(pass) =>  Authenticator.cryptPassword(pass)
            case _ => user.getPassword
          })
          user.getUserType match {
            case role => ()
            case _ => user = user.switchTo(UserRoles.valueOf(role))
          }
        user.commit
        user
      }
    }
    {
      user => Some(user.getUser_id,user.getLogin,user.getName,user.getSurname,(None,None),user.getUserType)
    }
  )

  val RoleOptions = Seq(
    "S"->"Student",
    "T"->"Teacher",
    "H"->"Headmaster")

}