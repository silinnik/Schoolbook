package models;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity
@DiscriminatorValue("T")
public class Teacher extends User {

@Column
@GeneratedValue( strategy = GenerationType.IDENTITY )
private int teacher_id;


public int getTeacher_id() {
	return getUser_id();
}

public void setTeacher_id(int teacher_id) {
	this.setUser_id(teacher_id);
}

public Teacher(String login, String name, String surname, String password){
	super(login, name, surname, password);
}



    public Teacher(){}

}
