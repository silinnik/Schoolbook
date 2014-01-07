package models;

import javax.persistence.*;

/**
 * Date: 12/26/13
 */
@Entity
public class MGrade extends BaseModel{


    public MGrade() {
    }

    public MGrade(MStudent student, MTimetableEntry timetable_entry, int grade_value, String grade_annotation) {
        this.student = student;
        this.timetable_entry = timetable_entry;
        this.grade_value = grade_value;
        this.grade_annotation = grade_annotation;
    }

    @ManyToOne
    private MStudent student;

    @ManyToOne
    private MTimetableEntry timetable_entry;

    @Column (nullable = false)
    private int grade_value;

    @Column
    private String grade_annotation;

    public MStudent getStudent() {
        return student;
    }

    public void setStudent(MStudent student) {
        this.student = student;
    }

    public MTimetableEntry getTimetable_entry() {
        return timetable_entry;
    }

    public void setTimetable_entry(MTimetableEntry timetable_entry) {
        this.timetable_entry = timetable_entry;
    }

    public int getGrade_value() {
        return grade_value;
    }

    public void setGrade_value(int grade_value) {
        this.grade_value = grade_value;
    }

    public String getGrade_annotation() {
        return grade_annotation;
    }

    public void setGrade_annotation(String grade_annotation) {
        this.grade_annotation = grade_annotation;
    }
}
