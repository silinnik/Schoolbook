package models;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher extends User {

public Teacher(){
super();
}

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
private int teacher_id;


public int getTeacher_id() {
	return teacher_id;
}

public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}


   
}
