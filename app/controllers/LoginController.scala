package controllers

import casemodels.{LoginData, UserData}
import play.api.mvc._

import models.repositories.UserRepository
import models.User
import play.api.mvc.Request
import play.api.data._
import play.api.data.Forms._
import scala.collection.JavaConversions._
import collection.mutable.ArrayBuffer
import org.mindrot.jbcrypt.BCrypt
/**
 * Date: 12/2/13
*/
object LoginController extends Controller{

  def requestLogin = Action { implicit request =>
    Ok(views.html.requestLogin render(LoginData.loginForm,session))
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
