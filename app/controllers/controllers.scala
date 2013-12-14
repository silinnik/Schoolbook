import models.repositories.UserRepository
import models.User
import play.api.mvc.Request

/**
 * Date: 12/14/13
 */

package object controllers {

  implicit def GetUserByRequest(implicit request:Request[Any]) : Option[User] = request.session.get("connected") match {
    case Some(username) => UserRepository.findByLogin(username)
    case _ => None
  }

}