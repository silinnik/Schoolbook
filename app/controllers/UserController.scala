package controllers

import controllers.formsdata.UserData
import play.api.mvc._
import models.repositories.UserRepository
import scala.collection.JavaConversions._

/**
 * This objects handles all the actions related to user management
 */
object UserController extends Controller{

  /**
   * Processes data for the new group and redirects user to the UserController.viewUserList action.
   * @return Redirect to the UserController.viewUserList if the data is correct. NadRequest with the form errors otherwise
   */
  def processNewUser = Action { implicit request =>
      UserData.userCreateForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestNewUser.render(formWithErrors,request)),
        correctUserData => {
          correctUserData.save()
          Redirect(routes.UserController.viewUserList).flashing(("result_message","User was successfully created!"))
        }
      )
  }

  /**
   * Shows the view, containing the form for the new user data.
   * @return View with the data form for the new user.
   */
  def requestNewUser = Action { implicit request =>

      Ok(views.html.requestNewUser.render(UserData.userCreateForm,request))
  }

  /**
   * Processes new data for the existing user and redirects user to the UserController.viewUserList action.
   * @return Redirect to the UserController.viewUserList action, if the form data is correct. BadRequest with the formerrors otherwise
   */

  def processEditUser = Action { implicit request =>
      UserData.userEditForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.requestEditUser.render(formWithErrors,request)),
        correctUserData => {
          correctUserData.update()
          Redirect(routes.UserController.viewUserList).flashing(("result_message","User was successfully updated!"))
        }
      )
  }

  /**
   * Shows the view, containing the form for the new data for existing user with the filled values.
   * @return View with the data form to edit existing user.
   */

  def requestEditUser(id : Int) = Action { implicit request =>
      Ok(views.html.requestEditUser.render(UserData.userEditForm fill( UserRepository.findById(id).get ),request ))
  }

  /**
   * Removes the user with the given id if such exists. Then redirects user to the UserController.viewUserList action.
   * @param id The user id to remove.
   * @return Redirect to the UserController.viewUserList action.
   */
  def removeUser(id: Int) = Action {
      UserRepository removeUser id
      Redirect(routes.UserController.viewUserList)
  }

  /**
   * Show the list of all the users present in the system.
   * @return View with the list of all the users
   */
  def viewUserList = Action { implicit request =>
      Ok(views.html.viewUserList.render(UserRepository.all().filter(_ => true).toArray,request))
  }

}
