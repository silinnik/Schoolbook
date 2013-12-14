package controllers

import models.User
import controllers.formsdata.UserData
import play.api.mvc._
import models.repositories.UserRepository
import scala.collection.JavaConversions._

object UserController extends Controller{

  /*
   *  Post actions are represented by two methods request and process
   *  request methods display required form
   *  form is then processed in the process method
   *  The validation is handled in the form definition (UserData, LoginData)
   *  TODO add authorization check
   *  TODO add error login handler
   */

  def processNewUser = Action { implicit request =>
      UserData.userCreateForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestNewUser.render(formWithErrors)),
        correctUserData => {
          correctUserData.save()
          Redirect(routes.UserController.viewUserList).flashing(("result_message","User was successfully created!"))
        }
      )
  }

  def requestNewUser = Action { implicit request =>

      Ok(views.html.requestNewUser.render(UserData.userCreateForm))
  }

  def processEditUser = Action { implicit request =>
      UserData.userEditForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestEditUser.render(formWithErrors)),
        correctUserData => {
          correctUserData.update()
          Redirect(routes.UserController.viewUserList).flashing(("result_message","User was successfully updated!"))
        }
      )
  }

  def requestEditUser(id : Int) = Action { implicit request =>
      Ok(views.html.requestEditUser.render(UserData.userEditForm fill( UserRepository.findById(id).get ) ))
  }

  def removeUser(id: Int) = Action {
      UserRepository removeUser id
      Redirect(routes.UserController.viewUserList)
  }

  def viewUserList = Action { implicit request =>
      Ok(views.html.viewUserList.render( UserRepository.all().toArray.asInstanceOf[Array[User]]))
  }

  def todo = Action { implicit request =>

    Ok(views.html.todo.render)

  }

}
