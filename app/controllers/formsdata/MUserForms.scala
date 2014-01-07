package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import models._
import repositories.MUsersRepository
import security.Authenticator
import scala.Some

/**
 * Date: 12/26/13
*/
object MUserForms {

  val userCreateForm = Form(
    mapping(
      "login" -> nonEmptyText(1, 32) .verifying(
        "User with this login already exists!", MUsersRepository.isLoginRegistered(_)
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
    {(login,name,surname,passwords,role) =>
        MUsersRepository.produceNewUser(login,Authenticator.cryptPassword(passwords._1),name,surname,role)}
    {user => Some(user.getLogin,user.getFirstName,user.getLastName,("",""),user.getUserType)}
  )

  val userEditForm = Form(
    mapping(
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
      )
    )
    {
      (login,name,surname,passwords) => {
        val user : MUser = MUsersRepository.findUserByLogin(login) match {
          case Some(possibleUser) => possibleUser
          case _ => throw new IllegalArgumentException("Such login is not registered!")
        }

        user setLogin login
        user setFirstName name
        user setLastName  surname
        user.setPassword(passwords._1 match {
          case Some(pass) =>  Authenticator.cryptPassword(pass)
          case _ => user.getPassword
        })
        user
      }
    }
    {user => Some(user.getLogin,user.getFirstName,user.getLastName,(None,None))}
  )

  val RoleOptions = Seq(
    "STUDENT"->"Student",
    "TEACHER"->"Teacher",
    "HEADMASTER"->"Headmaster")

}
