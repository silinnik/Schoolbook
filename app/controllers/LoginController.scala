package controllers

import controllers.formsdata.LoginData
import play.api.mvc._

/**
 * Date: 12/2/13
*/
object LoginController extends Controller{

  def requestLogin = Action { implicit request =>
    Ok(views.html.requestLogin.render(LoginData.loginForm))
  }

  def logout = Action { implicit request =>
    Redirect(routes.UserController.viewUserList).withNewSession
  }

  def processLogin = Action { implicit request =>
    LoginData.loginForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.requestLogin(formWithErrors)),
      loginAndPassword => Redirect(routes.UserController.viewUserList).withSession("connected"->loginAndPassword._1)
    )
  }

}
