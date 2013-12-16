package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.repositories.UserRepository
import security.Authenticator

/**
 * Date: 12/16/13
*/
object TimetableEntryData {

  val timetableEntryCreateForm = Form(
    mapping(
      "date" -> date,
      "number" -> nonEmptyText(1, 32),
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {
      (date,number,groupid,teacherid,subject) => {
        var user = UserRepository.findById(id).get
        user.setUser_id(id)
        user.setLogin(login)
        user.setName(name)
        user.setSurname(surname)
        user.setPassword(passwords._1 match {
          case Some(pass) =>  Authenticator.cryptPassword(pass)
          case _ => user.getPassword
        })
        role match {
          case user.getUserType => ()
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
}
