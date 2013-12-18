package models;
import play.db.ebean.Model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Homework
 *
 */
@Entity
public class Homework extends Model {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long homework_id;
/*

	@OneToOne(fetch=FetchType.LAZY, mappedBy="homework")
	private TimetableEntry timetable_entry;
*/

	@Column(nullable = false)
    private String homework_text;

    public Homework(TimetableEntry timetable_entry, String homework_text) {
        super();
        //this.timetable_entry = timetable_entry;
        this.homework_text = homework_text;
    }

    public Homework(){}

    public void setHomework_text(String homework_text) {
        this.homework_text = homework_text;
    }

    public long getHomework_id() {
		return homework_id;
	}

	public void setHomework_id(long homework_id) {
		this.homework_id = homework_id;
	}
/*
	public TimetableEntry getTimetable_entry() {
		return timetable_entry;
	}

	public void setTimetable_entry(TimetableEntry timetable_entry) {
		this.timetable_entry = timetable_entry;
	}*/

	public String getHomework_text() {
		return homework_text;
	}


	


	
	
	
	
}
