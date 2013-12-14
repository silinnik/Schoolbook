package models;
import play.db.ebean.Model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Subject
 *
 */
@Entity
public class Subject extends Model {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int subjectId;
	
	@Column(nullable = false )
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	
	
	
}
