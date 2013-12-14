package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
public class Event implements Serializable {

	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int event_id;
	
	@JoinTable(name="event_user")
	@ManyToMany
	private Collection<User> people;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private Date time;

	public int getEvent_id() {
		return event_id;
	}
	
	

	public Event(Collection<User> people, String type, Date time) {
		super();
		this.people = people;
		this.type = type;
		this.time = time;
	}



	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public Collection<User> getPeople() {
		return people;
	}

	public void setPeople(Collection<User> people) {
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
