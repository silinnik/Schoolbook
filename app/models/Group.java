package models;
import play.db.ebean.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity
@Table(name="GROUPP")
public class Group extends Model {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int group_id;
	
	@OneToMany(mappedBy = "group")
	private ArrayList<TimetableEntry> timetable_entries;
	
	@Column(nullable = false)
	private String name;
	
	@JoinTable(name="student_group")
	@ManyToMany
	private ArrayList<Student> students;
	
	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public ArrayList<TimetableEntry> getTimetable_entries() {
		return timetable_entries;
	}

	public void setTimetable_entries(ArrayList<TimetableEntry> timetable_entries) {
		this.timetable_entries = timetable_entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group(ArrayList<TimetableEntry> timetable_entries, String name,
			ArrayList<Student> students) {
		super();
		if(timetable_entries!=null){
		this.timetable_entries = timetable_entries;
		}
		else this.timetable_entries = new ArrayList<TimetableEntry>();
		this.name = name;
		if(students!=null){
		this.students = students;
	}
	else this.students = new ArrayList<Student>();
	}
	
	public Group(){
	}
   
}
