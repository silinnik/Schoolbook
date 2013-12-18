package controllers


import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import formsdata.{GroupData, UserData}
import models.{User, Group}
import com.avaje.ebean.Ebean
import scala.collection.JavaConversions._
import play.api.Routes
import models.repositories.GroupRepository


/**
 * Date: 12/14/13
*/
object GroupController extends Controller{

  def viewGroupList = Action { implicit request =>
     Ok(views.html.groupviews.GroupListPage.render(GroupRepository.all(),true,request))
  }

  def viewGroupMembers(groupId : Int) = TODO

  def requestNewGroup = Action { implicit request =>
    Ok(views.html.groupviews.GroupCreatePage.render(GroupData.groupCreateForm,request))
  }

  def processNewGroup = Action { implicit request =>
    GroupData.groupCreateForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.groupviews.GroupCreatePage.render(formWithErrors,request)),
      correctGroupInstance => {
        correctGroupInstance.save()
        Redirect(controllers.routes.GroupController.viewGroupList).flashing(("result_message","Group was successfully created!"))
      }
    )
  }

  def requestEditGroup(group_id : Int) = Action { implicit request =>
    GroupRepository.byId(group_id) match {
      case Some(group) => Ok(views.html.groupviews.GroupEditPage.render(GroupData.groupCreateForm.fill(group),request))
      case _ => BadRequest("Bad group id!")
    }

  }

  def processEditGroup = Action { implicit request =>
    GroupData.groupCreateForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.groupviews.GroupEditPage.render(formWithErrors,request)),
      correctGroupInstance => {
        correctGroupInstance.update()
        Redirect(controllers.routes.GroupController.viewGroupList).flashing(("result_message","Group was successfully created!"))
      }
    )
  }


  def processRemoveGroups(indices : String) = Action { implicit request =>
    val intIndicies = indices.replace(","," ").trim.split(" ").map(_.toInt).toArray
    for(i <- intIndicies){
      GroupRepository.byId(i) match {
        case Some(group) => group.delete()
        case _ => ()
      }
    }

    Redirect(controllers.routes.GroupController.viewGroupList)
  }

/*
  def processAddStudents = Action { request =>
     Ok()
  }

  def requestAddStudents = Action { request =>
     Ok()
  }

  /**
   * AJAX action
   */
  def requestEditGroup = TODO
  def processEditGroup = TODO

*/




}
