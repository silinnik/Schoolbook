package controllers.formsdata

import models._
import play.api.data.Form
import play.api.data.Forms._
import models.repositories.UserRepository


//case class UserData(login: String, name: String, surname: String, var password: String, role: Char) {
//  def toUser: User = new User(login, name, surname, BCrypt.hashpw(password,BCrypt.gensalt()), role)
//
//}

object UserData {

  //implicit def UserData2User(value : UserData) = value.toUser
  //implicit def User2UserData(value : User) = new UserData(value.getLogin,value.getName,value.getSurname,"",value.getUser_type)

  // def userDataSet : Array[UserData] = UserRepository.all().map(User2UserData(_)).toArray


/*  val userCreateForm = Form(
    mapping(
      "login" -> email .verifying(
        "User with this login already exists!", !UserRepository.isRegistered(_)
      ),
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
          "main" -> nonEmptyText(8, 16),
          "confirm" -> nonEmptyText(8, 16)
          ). verifying (
        "Password does not match it's confirmation", passwords => passwords._1 == passwords._2
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))

    )
    {
      (email,name,surname,passwords,role) => new User(email,name,surname,passwords._1,role.charAt(0))
    }
    {
       user => Some(user.getLogin,user.getName,user.getSurname,("",""),user.getUser_type.toString)
    }
  )*/

  val userCreateForm = Form(
    mapping(

      "login" -> nonEmptyText(6, 32) .verifying(
        "User with this login already exists!", user => !UserRepository.isRegistered(user)
      ),
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> nonEmptyText(8, 16),
        "confirm" -> nonEmptyText(8, 16)
      ). verifying (
        "Password does not match it's confirmation", passwords => passwords._1 == passwords._2
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))

    )
    {
      (login,name,surname,passwords,role) => { role match {
        case "S" => new Student(login,name,surname,passwords._1)
        case "T" => new Teacher(login,name,surname,passwords._1)
        case "H" => new Headmaster(login,name,surname,passwords._1)
        case _ => new User(login,name,surname,passwords._1)
        }
      }
    }
    {
      user => Some(user.getLogin,user.getName,user.getSurname,("",""),user.getType)
    }
  )



  /*val userEditForm = Form(
    mapping(
      "login" -> email,
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> optional(nonEmptyText(8,32)),
        "confirm" -> optional(nonEmptyText(8, 32))
      ). verifying (
        "New password does not match it's confirmation", _ match{
          case (pass,confirm) if !pass.isEmpty || !confirm.isEmpty => pass == confirm
          case _ => true
        }
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))
    )
    {
      (login,name,surname,passwords,role) => {
        UserData( login,
                  name,
                  surname,
                  passwords._1.getOrElse(UserRepository.find.byId(login).password),
                  role.charAt(0))
      }
    }
    {
      user => Some(user.login,user.name,user.surname,(None,None),user.getUser_type.toString)
    }
  )*/

  val userEditForm = Form(
    mapping(
      "id"  -> number . verifying (
        "User does not exist!", UserRepository.findById(_) != null
        ),
      "login" -> nonEmptyText(6, 32),
      "name" -> nonEmptyText(1, 32),
      "surname" -> nonEmptyText(1, 32),
      "password" -> tuple (
        "main" -> optional(nonEmptyText(8,32)),
        "confirm" -> optional(nonEmptyText(8, 32))
      ). verifying (
        "New password does not match it's confirmation", _ match{
          case (pass,confirm) if !pass.isEmpty || !confirm.isEmpty => pass == confirm
          case _ => true
        }
      ),
      "role" -> text .verifying( "Illegal role!",roleString=> UserData.RoleOptions.exists(x=>x._1==roleString))
    )
    {
      (id,login,name,surname,passwords,role) => {
        var user = UserRepository.findById(id).get
        user.setUser_id(id)
        user.setLogin(login)
        user.setName(name)
        user.setSurname(surname)
        user.setPassword(passwords._1.getOrElse(user.getPassword))
        if (role!=user.getType) user = role match {
            case "S" => user.switchToStudent()
            case "H" => user.switchToHeadmaster()
            case "T" => user.switchToTeacher()
            case _ => user
          }
        user
      }
    }
    {
      user => Some(user.getUser_id,user.getLogin,user.getName,user.getSurname,(None,None),user.getType)
    }
  )

  val RoleOptions = Seq(
    "S"->"Student",
    "T"->"Teacher",
    "H"->"Headmaster")

}