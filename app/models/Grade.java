package models;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Graduate
 *
 */
@Entity

public class Grade extends Model {

public Grade(){

}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long grade_id;
	
	@ManyToOne
	private Student student;

	@ManyToOne
	private TimetableEntry timetable_entry;
	
	@Column (nullable = false)
	int grade_value;
	
	@Column
	String grade_annotation;

    @Column(nullable = false)
	int week;

	public long getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(long graduation_id) {
		this.grade_id = graduation_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

	public TimetableEntry getTimetable_entry() {
		return timetable_entry;
	}

	public void setTimetable_entry(TimetableEntry timetable_entry) {
		this.timetable_entry = timetable_entry;
	}

	public int getGrade_value() {
		return grade_value;
	}

	public void setGrade_value(int grade_value) {
		this.grade_value = grade_value;
	}

	public String getGrade_annotation() {
		return grade_annotation;
	}

	public void setGrade_annotation(String grade_annotation) {
		this.grade_annotation = grade_annotation;
	}

	public Grade(Student student, TimetableEntry timetable_entry,
			int grade_value,int week, String grade_annotation) {
		super();
		this.student = student;
		this.timetable_entry = timetable_entry;
		this.grade_value = grade_value;
		this.grade_annotation = grade_annotation;
        this.week = week;
	}
	
	
   
}
