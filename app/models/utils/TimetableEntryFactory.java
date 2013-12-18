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
        Group group = GroupRepository.byId(groupId).get();
        Teacher teacher = UserRepository.findTeacherById(teacherId).get();
        Subject subject = SubjectRepository.byId(subjectId).get();
        return new TimetableEntry(day,number,group,teacher,subject);
    }

    public static TimetableEntry TimetableEntry(int id,int day, int number, int groupId, int teacherId, int subjectId){
        TimetableEntry entry = TimetableEntryRepository.byId(id).get();
        Group group = GroupRepository.byId(groupId).get();
        Teacher teacher = UserRepository.findTeacherById(teacherId).get();
        Subject subject = SubjectRepository.byId(subjectId).get();

        entry.setGroup(group);
        entry.setTeacher(teacher);
        entry.setSubject(subject);
        entry.setDay(day);
        entry.setNumber(number);

        return entry;
    }

}
