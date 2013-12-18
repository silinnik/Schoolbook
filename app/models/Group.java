package models;
import com.avaje.ebean.Ebean;
import models.repositories.GroupRepository;
import play.db.ebean.Model;
import scala.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public Set<Student> getStudents() {
        return Ebean.find(Student.class).where().eq("group_id",this.getGroup_id()).findSet();
    }

    @OneToMany(mappedBy = "group",cascade=CascadeType.PERSIST)
	private Set<TimetableEntry> timetable_entries;
	
	@Column(nullable = false)
	private String name;

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Set<TimetableEntry> getTimetable_entries() {
		return timetable_entries;
	}

	public void setTimetable_entries(Set<TimetableEntry> timetable_entries) {
		this.timetable_entries = timetable_entries;
	}

    public void addStudent(Student student){
        student.setGroup(this.getGroup_id());
    }

    public void removeStudent(Student student){
        student.setGroup(-1);
    }

    public boolean hasStudent(Student student){
       return student.getGroup().getGroup_id() == this.getGroup_id();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group(Set<TimetableEntry> timetable_entries, String name, Set<Student> students) {
        this.timetable_entries = timetable_entries == null ? new HashSet<TimetableEntry>() : timetable_entries;
        if(students!=null)
        for(Student student : students){
            this.addStudent(student);
        }
		this.name = name;
	}
	
	public Group(){}
   
}
