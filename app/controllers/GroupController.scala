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

  def viewGroupList(groupId: Int) = Action { implicit request =>
     Ok(views.html.groupviews.GroupListPage.render(GroupRepository.all(),false,request))
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
        Redirect(routes.GroupController.viewGroupList(correctGroupInstance.getGroup_id)).flashing(("result_message","Group was successfully created!"))
      }
    )
  }

  def viewGroupMembers(groupId : Int) = TODO

  def requestEditGroup = Action { implicit request =>
    Ok(views.html.groupviews.GroupEditPage.render(GroupData.groupCreateForm,request))
  }

  def processEditGroup = Action { implicit request =>
    GroupData.groupCreateForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.groupviews.GroupEditPage.render(formWithErrors,request)),
      correctGroupInstance => {
        correctGroupInstance.update()
        Redirect(routes.GroupController.viewGroupList(correctGroupInstance.getGroup_id)).flashing(("result_message","Group was successfully created!"))
      }
    )
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
