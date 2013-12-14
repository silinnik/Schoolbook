package models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity
public class Group implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int group_id;
	
	@OneToMany(mappedBy = "group")
	private Collection<TimetableEntry> timetable_entries;
	
	@Column(nullable = false)
	private String name;
	
	@JoinTable(name="student_group")
	@ManyToMany
	private Collection<Student> students;
	
	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Collection<TimetableEntry> getTimetable_entries() {
		return timetable_entries;
	}

	public void setTimetable_entries(Collection<TimetableEntry> timetable_entries) {
		this.timetable_entries = timetable_entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group(Collection<TimetableEntry> timetable_entries, String name,
			Collection<Student> students) {
		super();
		this.timetable_entries = timetable_entries;
		this.name = name;
		this.students = students;
	}
	
	
   
}
