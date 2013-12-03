package controllers.casemodels

import models.User
import play.api.data.Form
import play.api.data.Forms._

case class UserData(email: String, name: String, surname: String, password: String, role: String) {
  def toUser: User = new User(email, name, surname, password, role)
}

object UserData {
  val userForm = Form(
    mapping(
      "email" -> email,
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> nonEmptyText(8, 16),
      "role" -> text
    )(UserData.apply)(UserData.unapply)
  )
}