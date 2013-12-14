package models;	

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@DiscriminatorValue("S")
public class Student extends User {
   
	@Column(nullable=false)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int student_id;
	
	public Student(String login, String name, String surname, String password){
		super(login, name, surname, password, 'S');
	}

	
}
