package models;
import play.db.ebean.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TimetableEntry
 *
 */
@Entity

public class TimetableEntry extends Model {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long timetable_entry_id;
	
	@Column(nullable = false)
	private Date time;
	
	@ManyToOne
	private Group group;
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToOne
	private Subject subject;
	
	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="timetable_entry")
	private Homework homework;
	
	@OneToMany(mappedBy = "timetable_entry")
	private ArrayList<Grade> grades;
	
	
	private static final long serialVersionUID = 1L;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public TimetableEntry(Date time, Group group, Teacher teacher,
			Subject subject, Homework homework, ArrayList<Grade> grades) {
		super();
		if(grades!=null){
			this.grades = grades;
		}
		else{
			this.grades = new ArrayList<Grade>();
		}
		this.time = time;
		this.group = group;
		this.teacher = teacher;
		this.subject = subject;
		this.homework = homework;
	}
	
	public TimetableEntry(){}
	
	
   
}
