package models;
import play.db.ebean.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
public class Event extends Model {

	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int event_id;
	
	@JoinTable(name="event_user")
	@ManyToMany
	private ArrayList<User> people;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private Date time;

	public int getEvent_id() {
		return event_id;
	}
	
	

	public Event(ArrayList<User> people, String type, Date time) {
		super();
		if(people != null){
		this.people = people;
		}
		else{
			this.people = new ArrayList<User>();
		}
		this.type = type;
		this.time = time;
	}



	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public ArrayList<User> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<User> people) {
		this.people = people;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
   
}
