package controllers

import play.api.mvc._
import formsdata._
import models.repositories.{UserRepository, GroupRepository}

/**
 * This controller handles all the
*/
object GroupController extends Controller{

  /**
   * View with the lsit of groups that currently present in the system.
   * @return
   */
  def viewGroupList = Action { implicit request =>
     Ok(views.html.groupviews.GroupListPage.render(GroupRepository.all(),true,request))
  }

  /**
   * Shows the view with the form for the new group data.
   * @return View with the empty group form.
   */
  def requestNewGroup = Action { implicit request =>
    Ok(views.html.groupviews.GroupCreatePage.render(GroupData.groupCreateForm,UserRepository.allStudents,request))
  }


  /**
   * Processes data for the new group.
   * @return Redirect to the viewGroupList action if the form had correct data. Badrequest with the form errors otherwise.
   */
  def processNewGroup = Action { implicit request =>
    GroupData.groupCreateForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.groupviews.GroupCreatePage.render(formWithErrors,UserRepository.allStudents,request)),
      correctGroupInstance => {
        correctGroupInstance.save()
        Redirect(controllers.routes.GroupController.viewGroupList).flashing(("result_message","Group was successfully created!"))
      }
    )
  }

  /**
   * Shows view with the form for the group editing.
   * @param group_id
   * @return View with the form to edit group data with filled values, if the group with the given group_id exists. BadRequest with the error message otherwise.
   */
  def requestEditGroup(group_id : Int) = Action { implicit request =>
    GroupRepository.byId(group_id) match {
      case Some(group) => Ok(views.html.groupviews.GroupEditPage.render(GroupData.groupCreateForm.fill(group),request))
      case _ => BadRequest("Bad group id!")
    }
  }

  /**
   * Processes new data for the existing group.
   * @return Redirect to the viewGroupList action if the form had correct data. Badrequest with the form errors otherwise.
   */
  def processEditGroup = Action { implicit request =>
    GroupData.groupCreateForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.groupviews.GroupEditPage.render(formWithErrors,request)),
      correctGroupInstance => {
        correctGroupInstance.update()
        Redirect(controllers.routes.GroupController.viewGroupList).flashing(("result_message","Group was successfully edited!"))
      }
    )
  }

  /**
   * Processes string of indices, and deletes corresponding groups from the system
   * @param indices String of indices to remove
   * @return Redirect to the viewGroupList action, flashing the opertaion result message.
   */
  def processRemoveGroups(indices : String) = Action { implicit request =>

    for(i <- utils.utils.indicesFromString(indices)){
      GroupRepository.byId(i) match {
        case Some(group) => group.delete()
        case _ => ()
      }
    }
    Redirect(controllers.routes.GroupController.viewGroupList).flashing(("result_message","Selected groups were successfully removed!"))
  }

}
