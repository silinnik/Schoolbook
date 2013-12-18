package controllers.formsdata

import scala.Some
import models.utils.TimetableEntryFactory
import scala.Some
import models.repositories.TimetableEntryRepository
import scala.Some
import play.api.data.Form
import play.api.data.Forms._

object TimetableEntryData {

  val timetableEntryCreateForm = Form(
    mapping(
      "day" -> number,
      "number" -> number,
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {(day,number,groupId,teacherId,subjectId) => TimetableEntryFactory.TimetableEntry(day,number,groupId,teacherId,subjectId)}
    {timetableEntry => Some(timetableEntry.getDay,timetableEntry.getNumber,timetableEntry.getGroup.getGroup_id,timetableEntry.getTeacher.getTeacher_id,timetableEntry.getSubject.getSubjectId)}
  )

  val timetableEntryEditForm = Form(
    mapping(
      "id" -> number,
      "day" -> number,
      "number" -> number,
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {(id,day,number,groupId,teacherId,subjectId) => {TimetableEntryFactory.TimetableEntry(id,day,number,groupId,teacherId,subjectId)}
    }
    {timetableEntry => Some(timetableEntry.getTimetable_entry_id,timetableEntry.getDay,timetableEntry.getNumber,timetableEntry.getGroup.getGroup_id,timetableEntry.getTeacher.getTeacher_id,timetableEntry.getSubject.getSubjectId)}
  )
}
