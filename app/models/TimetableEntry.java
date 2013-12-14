package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TimetableEntry
 *
 */
@Entity

public class TimetableEntry implements Serializable {

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
			Subject subject, Homework homework) {
		super();
		this.time = time;
		this.group = group;
		this.teacher = teacher;
		this.subject = subject;
		this.homework = homework;
	}
	
	
   
}
