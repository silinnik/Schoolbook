package controllers.formsdata


import play.api.data.Form
import play.api.data.Forms._
import models.repositories.UserRepository
import org.mindrot.jbcrypt.BCrypt
import security.Authenticator

/**
 * Date: 12/2/13
*/

object LoginData {

  val loginForm = Form(
    tuple (
      "login" -> nonEmptyText(1, 32),
      "password" -> nonEmptyText(8, 16)
    ).verifying("Invalid login or Password!", t => Authenticator.authenticateLoginData(t) )
  )


}
