package models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Headmaster
 *
 */
@Entity
@DiscriminatorValue("H")
public class Headmaster extends User {

	@Column
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int headmaster_id;

	public int getHeadmaster_id() {
		return getUser_id();
	}

	public void setHeadmaster_id(int headmaster_id) {
		this.setUser_id(headmaster_id);
	}
	
	public Headmaster(){

	}


    public Headmaster (String login, String name, String surname, String password){
		super(login, name, surname, password);
	}

   
}
