package models.utils;

import models.*;
import models.repositories.*;
import models.TimetableEntry;

import java.sql.Date;

/**
 * Date: 12/16/13
 */
public class TimetableEntryFactory {

    public static TimetableEntry TimetableEntry(Date date, int number, int groupId, int teacherId, int subjectId){
        Group group = GroupRepository.byId(groupId).get();
        Teacher teacher = UserRepository.findTeacherById(teacherId).get();
        Subject subject = SubjectRepository.byId(subjectId).get();
        return new TimetableEntry(date,number,group,teacher,subject,null,null);
    }

    public static TimetableEntry TimetableEntry(int id,Date date, int number, int groupId, int teacherId, int subjectId){
        TimetableEntry entry = TimetableEntryRepository.byId(id).get();
        Group group = GroupRepository.byId(groupId).get();
        Teacher teacher = UserRepository.findTeacherById(teacherId).get();
        Subject subject = SubjectRepository.byId(subjectId).get();

        entry.setGroup(group);
        entry.setTeacher(teacher);
        entry.setSubject(subject);
        entry.setTime(date);
        entry.setNumber(number);

        return entry;
    }

}
