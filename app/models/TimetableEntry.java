package models;
import models.repositories.GroupRepository;
import models.repositories.SubjectRepository;
import models.repositories.UserRepository;
import play.db.ebean.Model;

import java.io.Serializable;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * This entity represents a lesson.
 * The lesson it self is represented with TimetableEntry - a combination of date, group, subject and a teacherl
    */
@Entity
public class TimetableEntry extends Model {

    private static final long serialVersionUID = 1L;
    private Calendar cal = Calendar.getInstance();


    public int getTimetable_entry_id() {
        return timetable_entry_id;
    }

    public void setTimetable_entry_id(int timetable_entry_id) {
        this.timetable_entry_id = timetable_entry_id;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int timetable_entry_id;

    /**
     * Date of the lesson
     */
	@Column(nullable = false)
	private int day;

    /**
     * Number of this lesson in the sequence of lessons
     */
    @Column(nullable = false)
    private int number;

    /**
     * Group which visits this lesson
     */
    @Column
	private int group_id;

    /**
     * Teacher
     */
    @Column
	private int teacher;

    /**
     * Subject that is taught on this lesson
     */
    @Column
	private int subject;


    /**
     * Basic constructor for the TimetableEntry
     * @param time Time at which the lesson is given
     * @param number Number of lesson in the sequence of lessons
     * @param group Group which attends this lesson
     * @param teacher Teacher that teaches this lesson
     * @param subject Subject that is taught on this lesson
     */
    public TimetableEntry(int time, int number, int group, int teacher,
                          int subject) {
        super();
        this.number = number;
        this.group_id = group;
        this.teacher = teacher;
        this.subject = subject;
    }

    public TimetableEntry(){}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Group getGroup() {
		return GroupRepository.byId(group_id).get();
	}

	public void setGroup(int group) {
		this.group_id = group;
	}

	public Teacher getTeacher() {
		return UserRepository.findTeacherById(teacher).get();
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return SubjectRepository.byId(subject).get();
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

}
