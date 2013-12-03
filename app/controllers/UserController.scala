package controllers

import casemodels.UserData
import play.api.mvc._
import models.repositories.UserRepository
import models.User

import play.api.mvc.Request
import play.api.data._
import play.api.data.Forms._
import scala.collection.JavaConversions._
import collection.mutable.ArrayBuffer


/**
 * Date: 12/2/13
 */


object UserController extends Controller {

  val userForm = UserData.userForm


  def processUser = Action {
    implicit request =>
      val receivedForm = userForm.bindFromRequest()
      if (receivedForm.hasErrors) BadRequest(views.html.requestUser.render(receivedForm))
      else {
        receivedForm.get.toUser.save()
        Redirect("/UserList")
      }

  }

  def requestUser = Action {
    Ok(views.html.requestUser.render(userForm))

  }

  /*def editUser = Action {
     Ok("Ok")
  } */

  def removeUser(login: String) = Action {
    UserRepository.find.byId(login).delete()
    Redirect("/UserList")
  }

  def viewUserList = Action {

    val userSet = UserRepository.all()
    Ok(views.html.viewUserList.render(userSet.map(_.toUserData).toArray))
  }

}
