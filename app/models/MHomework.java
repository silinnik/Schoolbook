package models;

import javax.persistence.*;

/**
 * Date: 12/26/13
 */

@Entity
public class MHomework extends BaseModel {

    public MHomework() {
    }

    public MHomework(MTimetableEntry timetable_entry, String homework_text) {
        this.timetable_entry = timetable_entry;
        this.homework_text = homework_text;
    }

    @OneToOne
	private MTimetableEntry timetable_entry;

    @Column(nullable = false)
    private String homework_text;

    public MTimetableEntry getTimetable_entry() {
        return timetable_entry;
    }

    public void setTimetable_entry(MTimetableEntry timetable_entry) {
        this.timetable_entry = timetable_entry;
    }

    public String getHomework_text() {
        return homework_text;
    }

    public void setHomework_text(String homework_text) {
        this.homework_text = homework_text;
    }
}
