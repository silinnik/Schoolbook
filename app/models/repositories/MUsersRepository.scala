package models.repositories

import models._

/**
 * Date: 12/26/13
*/
object MUsersRepository {

  val innerUsersRepo = new Repository(classOf[MUser])
//  val innerPersonnelRepo = new Repository(classOf[MPersonnel])
  val innerTeachersRepo = new Repository(classOf[MTeacher])
  val innerStudentsRepo = new Repository(classOf[MStudent])
  val innerHeadmastersRepo = new Repository(classOf[MHeadmaster])

  def getAllStudents = innerStudentsRepo.all()

  def getAllTeachers = innerTeachersRepo.all()

  def getAllHeadmasters = innerHeadmastersRepo.all()

 // def getAllPersonnel = innerPersonnelRepo.all()

  def getAllUsers = innerUsersRepo.all()

  def findUserByIndex(index : Int) = innerUsersRepo.get(index)

  def findUserByLogin(login : String) = Option(innerUsersRepo.find.where().eq("login",login).findUnique())

  def isLoginRegistered(login : String) = !findUserByLogin(login).isEmpty

  def produceNewUser( role :String) : MUser = role match {
      case "STUDENT" => new MStudent
      case "TEACHER" => new MTeacher
      case "HEADMASTER" => new MHeadmaster
      //case "PERSONNEL" => new MStudent
      case _ => throw new IllegalArgumentException("Bad user type value")
  }

  def produceNewUser(login:String,  name:String, last_name:String, password:String, role:String) : MUser = {
      val newUser = produceNewUser(role)
      newUser setLogin login
      newUser setPassword password
      newUser setFirstName name
      newUser setLastName last_name
      newUser
  }

}
