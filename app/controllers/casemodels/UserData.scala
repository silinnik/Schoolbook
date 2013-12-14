package controllers.casemodels

import models.User
import play.api.data.Form
import play.api.data.Forms._
import org.mindrot.jbcrypt.BCrypt
import models.repositories.UserRepository
import play.api.Play
import scala.collection.JavaConversions._

case class UserData(email: String, name: String, surname: String, var password: String, role: String) {
  def toUser: User = new User(email, name, surname, BCrypt.hashpw(password,BCrypt.gensalt()), role)

}

object UserData {

  implicit def UserData2User(value : UserData) = value.toUser
  implicit def User2UserData(value : User) = new UserData(value.email,value.name,value.surname,"",value.role)

  def userDataSet : Array[UserData] = UserRepository.all().map(User2UserData(_)).toArray


  val userCreateForm = Form(
    mapping(
      "email" -> email .verifying(
        "User with this email already exists!", !UserRepository.isRegistered(_)
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
     (email,name,surname,passwords,role) => UserData(email,name,surname,passwords._1,role)
    }
    {
     user => Some(user.email,user.name,user.surname,("",""),user.role)
    }
  )

  val userEditForm = Form(
    mapping(
      "email" -> email,
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> optional(nonEmptyText(8,32)),
        "confirm" -> optional(nonEmptyText(8, 32))
      ). verifying (
        "New password does not match it's confirmation", _ match{
          case (pass,confirm) if !pass.isEmpty || !confirm.isEmpty => pass == confirm
          case _ => true
        }
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))
    )
    {
      (email,name,surname,passwords,role) => {
        UserData( email,
                  name,
                  surname,
                  passwords._1.getOrElse(UserRepository.find.byId(email).password),
                  role)
      }
    }
    {
      user => Some(user.email,user.name,user.surname,(None,None),user.role)
    }
  )

  val RoleOptions = Seq(
    "Student"->"Student",
    "Teacher"->"Teacher",
    "Headmaster"->"Headmaster")

}