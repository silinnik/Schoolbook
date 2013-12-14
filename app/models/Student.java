package models;	

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student extends User {
   
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int student_id;

public Student(){
super();
}
	
}
