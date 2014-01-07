package controllers

import controllers.formsdata.LoginData
import play.api.mvc._
import models.repositories.UserRepository

/**
 * This class handles all the processes related to user Login/Logout
*/
object LoginController extends Controller{

  /**
   * Shows the view with the form to enter Username and Login
   * @return View with the form for user data.
   */
  def requestLogin = Action { implicit request =>
    Ok(views.html.requestLogin.render(LoginData.loginForm,request))
  }

  /**
   * Redirects user to the main page with the empty session data
   * @return Redirect to the MainController.viewMainPage
   */
  def logout = Action { implicit request =>
    Redirect(routes.UserController.viewUserList).withNewSession
  }

  /**
   * Processes user data and redirects him to the MainController.viewMainPage action, if the data is correct
   * @return Redirect to MainController.viewMainPage action if the data is correct. BadRequest with the form errors otherwise
   */
  def processLogin = Action { implicit request =>
    LoginData.loginForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.requestLogin.render(formWithErrors,request)),
      loginAndPassword => Redirect(routes.UserController.viewUserList)
         .withSession("connected"->loginAndPassword._1,
                      "role"     ->UserRepository.findByLogin(loginAndPassword._1).get.getUserType)
    )
  }

}
