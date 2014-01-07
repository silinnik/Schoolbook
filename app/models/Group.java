package models;
import com.avaje.ebean.Ebean;
import models.repositories.GroupRepository;
import models.repositories.UserRepository;
import play.db.ebean.Model;
import scala.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	
	@Column(nullable = false)
	private String name;

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Set<TimetableEntry> getTimetable_entries() {
		return Ebean.find(TimetableEntry.class).where().eq("group_id",this.getGroup_id()).findSet();
	}

	public void setTimetable_entries(Set<TimetableEntry> timetable_entries) {
		for(TimetableEntry timeTableEntry : timetable_entries){
            timeTableEntry.setGroup(this.getGroup_id());
            timeTableEntry.update();
        }
	}


    public void setStudents(Set<Student> newStudents){
        for(Student oldStudent : getStudents()){
            oldStudent.setGroup(-1);
            oldStudent.update();
        }

        for(Student newStudent : newStudents){
            newStudent.setGroup(getGroup_id());
            newStudent.update();
        }
    }

    public void setStudents(List<Integer> newStudentsIndices){
        for(Student oldStudent : getStudents()){
            oldStudent.setGroup(-1);
            oldStudent.update();
        }

        for(Student newStudent : UserRepository.byStudentIds(newStudentsIndices)){
            newStudent.setGroup(getGroup_id());
            newStudent.update();
        }
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

    public String getStudentIds(){
        String indices = "";
        for(Student student : getStudents()){
            indices+=student.getStudent_id()+",";
        }
        return indices;
    }

	public Group(Set<TimetableEntry> timetable_entries, String name, Set<Student> students) {
        if(timetable_entries!=null){
            this.setTimetable_entries(timetable_entries);
        }
        if(students!=null)
            setStudents(students);
		this.name = name;
	}
	
	public Group(){}
   
}
