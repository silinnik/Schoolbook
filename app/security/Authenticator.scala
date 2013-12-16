package security

import models.repositories.UserRepository
import org.mindrot.jbcrypt.BCrypt

/**
 * Date: 12/3/13
*/
object Authenticator {
  def authenticateLoginData( nameAndPassword : (String,String)) =
        UserRepository.findByLogin(nameAndPassword._1) match {
          case Some(user) => BCrypt.checkpw(nameAndPassword._2,user.getPassword)
          case _=> false
        }

  def cryptPassword(pass : String) = {
    BCrypt.hashpw(pass,BCrypt.gensalt())
  }
}
