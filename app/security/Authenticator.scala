package security

import models.repositories.UserRepository
import org.mindrot.jbcrypt.BCrypt

/**
 * Date: 12/3/13
*/
object Authenticator {
  def authenticateLoginData( nameAndPassword : (String,String)) =
        UserRepository.findByEmail(nameAndPassword._1) match {
          case Some(user) => BCrypt.checkpw(nameAndPassword._2,user.password)
          case _=> false
        }
}
