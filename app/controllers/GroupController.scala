package controllers
import  play.api.mvc._
import models.{User, Group}
import com.avaje.ebean.Ebean
import scala.collection.JavaConversions._
/**
 * Date: 12/14/13
*/
object GroupController extends Controller{

  def viewGroup(groupId: Int) = Action { request =>
    val userList = Ebean.find(classOf[Group]).where.eq("group_id", groupId.toString).findUnique.getStudents.map(_.asInstanceOf[User]).toArray.sortBy(_.getSurname)

    Ok(views.html.viewUserList.render(userList,request))
  }
  def requestNewGroup = TODO
  def processNewGroup = TODO
  def requestEditGroup = TODO
  def processEditGroup = TODO

}
