package models;
import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

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
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "group",cascade=CascadeType.PERSIST)
	private Set<TimetableEntry> timetable_entries;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "group")
	private Set<Student> students;
	
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
        students.add(student);
    }

    public void removeStudent(Student student){
        if(hasStudent(student))
            students.remove(student);
    }

    public boolean hasStudent(Student student){
        for(Student studentInGroup : this.getStudents()){
            if(studentInGroup.getStudent_id() == student.getStudent_id())
                return true;
        }
        return false;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group(Set<TimetableEntry> timetable_entries, String name, Set<Student> students) {
        this.timetable_entries = timetable_entries == null ? new HashSet<TimetableEntry>() : timetable_entries;
        this.students = students == null  ?  new HashSet<Student>() : students;
		this.name = name;
	}
	
	public Group(){}
   
}
