package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.repositories.UserRepository
import models.{User, Headmaster, Teacher, Student}
import security.Authenticator

/**
 * Date: 12/15/13
*/
object GroupData {
/*  val userCreateForm = Form(
    mapping(

      "name" -> nonEmptyText(6, 32) .verifying(
        "User with this login already exists!", user => !UserRepository.isLoginRegistered(user)
      ),
      "studentIndicies" -> text

    )
    {
      (login,name) => {
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
      user => Some(user.getLogin,user.getName)
    }
  )*/
}
