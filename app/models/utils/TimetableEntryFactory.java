package models.utils;

import models.*;
import models.repositories.*;
import models.TimetableEntry;

import java.sql.Date;

/**
 * Date: 12/16/13
 */
public class TimetableEntryFactory {

    public static TimetableEntry TimetableEntry(int day, int number, int groupId, int teacherId, int subjectId){

        return new TimetableEntry(day,number,groupId,teacherId,subjectId);
    }

    public static TimetableEntry TimetableEntry(int id,int day, int number, int groupId, int teacherId, int subjectId){
        TimetableEntry entry = TimetableEntryRepository.byId(id).get();

        entry.setGroup(groupId);
        entry.setTeacher(teacherId);
        entry.setSubject(subjectId);
        entry.setDay(day);
        entry.setNumber(number);

        return entry;
    }

}
