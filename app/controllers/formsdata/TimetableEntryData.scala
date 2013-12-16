package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.utils.TimetableEntryFactory
import scala.Some
import models.repositories.TimetableEntryRepository

object TimetableEntryData {

  val timetableEntryCreateForm = Form(
    mapping(
      "date" -> date,
      "number" -> number,
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {(date,number,groupId,teacherId,subjectId) => TimetableEntryFactory.TimetableEntry(new java.sql.Date(date.getTime),number,groupId,teacherId,subjectId)}
    {timetableEntry => Some(timetableEntry.getTime,timetableEntry.getNumber,timetableEntry.getGroup.getGroup_id,timetableEntry.getTeacher.getTeacher_id,timetableEntry.getSubject.getSubjectId)}
  )

  val timetableEntryEditForm = Form(
    mapping(
      "id" -> number,
      "date" -> date,
      "number" -> number,
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {(id,date,number,groupId,teacherId,subjectId) => {TimetableEntryFactory.TimetableEntry(id,new java.sql.Date(date.getTime),number,groupId,teacherId,subjectId)}
    }
    {timetableEntry => Some(timetableEntry.getTimetable_entry_id,timetableEntry.getTime,timetableEntry.getNumber,timetableEntry.getGroup.getGroup_id,timetableEntry.getTeacher.getTeacher_id,timetableEntry.getSubject.getSubjectId)}
  )
}
