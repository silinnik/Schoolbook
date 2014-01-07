package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import models.{MTeacher, MTimetableEntry}
import models.repositories.{MSubjectsRepository, MUsersRepository, MGroupsRepository}

/**
 * Date: 1/5/14
 */
object MTimetableForms {

  val timetableEntryCreateForm = Form(
    mapping(
      "day" -> number,
      "year" -> number,
      "number" -> number,
      "week" -> number,
      "groupid" -> number,
      "teacherid" -> number,
      "subjectid" -> number
    )
    {(day,year,number,week,groupId,teacherId,subjectId) => new MTimetableEntry(year,week,day,number,groupId,teacherId,subjectId)}
    {timetableEntry => Some(timetableEntry.getDay,
                            timetableEntry.getYear,
                            timetableEntry.getNumber,
                            timetableEntry.getWeek,
                            {if(timetableEntry.getGroup != null) timetableEntry.getGroup.getId.toInt else 0},
                            {if(timetableEntry.getTeacher != null) timetableEntry.getTeacher.getId.toInt else 0},
                            {if(timetableEntry.getSubject != null) timetableEntry.getSubject.getId.toInt else 0})

    }
  )
/*

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
*/

}
