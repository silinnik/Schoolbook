package controllers

import play.api.mvc._
import models.repositories.{MGradesRepository, MTimetableRepository, TimetableEntryRepository}
import scala.collection.JavaConversions._
import java.util.{GregorianCalendar, Calendar}
import java.sql.Date
import controllers.formsdata.MTimetableForms
import models.{MTimetableEntry, TimetableEntry}

/**
 * This class handles tasks related to timetable managing
 */
object TimetableController extends Controller {

  /**
   * Shows the time table for the group with the given ID
   * @param groupId Group id
   * @return View with timetable for the group with the given id, if the such group exists. BadRequest with the error message otherwise.
   */
  def showTimetableForGroup(groupId: Int) = TODO

  def fallback_GroupTimetableEntryFormSubmit() = Action {
    Ok("To be implemented!")
  }

  def ajax_GroupTimetableEntryFormSubmit() = Action {
    implicit request =>
      MTimetableForms.timetableEntryCreateForm.bindFromRequest().fold(
        formWithErrors => {
          println(formWithErrors.errors.mkString("\n"))
          Ok(views.html.timetableviews.modals.GroupTimetableEntryFormRequestModal(formWithErrors) + "DFSDFDSFFSD")
        },
        correctUserData => {
          println("SAVING")

          correctUserData.save()
          Ok("Timetable entry was sucessfully added!")
        }
      )
  }

  def ajax_TimetableGradesSubmit() = Action {
    Ok("To be implemented")
  }

  def ajax_TimetableGradesRequest(timetableId: Int) = Action {

    val students = MTimetableRepository.findById(timetableId).getGroup.getStudents
    val grades = MGradesRepository.findForTimetableId(timetableId)

    val chart = students.map(student => {
      (student, grades.find(_.getStudent.equals(student)))
    })

      Ok(views.html.GradesViews.modals.GradesListModal(chart))

  }

  def ajax_GroupTimetableEntryFormRequest(year: Int, week: Int, day: Int, number: Int, group_id: Int) = Action {
    Ok(views.html.timetableviews.modals.GroupTimetableEntryFormRequestModal(MTimetableForms.timetableEntryCreateForm.fill(new MTimetableEntry(year, week, day, number, 1, 1, 1))))
  }

}
