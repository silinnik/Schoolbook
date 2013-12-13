package controllers

import casemodels.UserData
import play.api.mvc._
import models.repositories.UserRepository


object UserController extends Controller {

  /*
   *  Post actions are represented by two methods request and process
   *  request methods display required form
   *  form is then processed in the process method
   *  The validation is handled in the form definition (UserData, LoginData)
   *  TODO add authorization check
   *  TODO add error email handler
   */

  def process(data : UserData) : Result = {
      UserRepository commit data
      Redirect(routes.UserController.viewUserList)
  }

  def processNewUser = Action { implicit request =>
      UserData.userCreateForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestNewUser(formWithErrors)),
        correctUserData => process(correctUserData)
      )
  }

  def requestNewUser = Action { implicit request =>
      Ok(views.html.requestNewUser.render( UserData.userCreateForm,session ))
  }

  def processEditUser = Action { implicit request =>
      UserData.userEditForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestEditUser(formWithErrors)),
        correctUserData => process(correctUserData)
      )
  }

  def requestEditUser(email : String) = Action { implicit request =>
      Ok(views.html.requestEditUser.render(UserData.userEditForm fill( UserRepository.findByEmail(email).get ),session ))
  }

  def removeUser(email: String) = Action {
      UserRepository removeUser email
      Redirect(routes.UserController.viewUserList)
  }

  def viewUserList = Action { implicit request =>
      Ok(views.html.viewUserList.render( UserData.userDataSet ,session))
  }

}
