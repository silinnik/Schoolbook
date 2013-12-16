package models;	

import com.avaje.ebean.Ebean;
import models.repositories.GroupRepository;
import scala.Option;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@DiscriminatorValue("S")
public class Student extends User {
   
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
	public Student(String login, String name, String surname, String password){
		super(login, name, surname, password);
	}

	public Student(){}

    /**
     * retrieves the student it
     * @return int representing student id
     */
	public int getStudent_id() {
		return student_id;
	}

    /**
     * Sets the student id
     * @param student_id
     */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
    }

    /**
     * Returns "S"
     * @return "S"
     */
    @Override
    public String getUserType(){
          return "S";
    }

    /**
     * Returns the group, student belongs to
     * @return Optional value which may contain the
     */
    public Option<Group> getGroup(){
       return GroupRepository.byStudent(this);
    }

	@ManyToOne
	private Group group;

	public Group getGroup(){
	return this.group;
	}

	public void setGroup(Group group){
	this.group = group;
	}
	
}


	


