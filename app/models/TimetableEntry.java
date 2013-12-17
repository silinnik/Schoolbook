package models;
import play.db.ebean.Model;

import java.io.Serializable;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * This entity represents a lesson.
 * The lesson it self is represented with TimetableEntry - a combination of date, group, subject and a teacherl
    */
@Entity
public class TimetableEntry extends Model {

    private static final long serialVersionUID = 1L;
    private Calendar cal = Calendar.getInstance();


    public int getTimetable_entry_id() {
        return timetable_entry_id;
    }

    public void setTimetable_entry_id(int timetable_entry_id) {
        this.timetable_entry_id = timetable_entry_id;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int timetable_entry_id;

    /**
     * Homework for this lesson
     */
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="timetable_entry")
    private Homework homework;

    /**
     * Set of grades that students got from this lesson
     */
    @OneToMany(mappedBy = "timetable_entry")
    private Set<Grade> grades;

    /**
     * Date of the lesson
     */
	@Column(nullable = false)
	private Date time;

    /**
     * Number of this lesson in the sequence of lessons
     */
    @Column(nullable = false)
    private int number;

    /**
     * Group which visits this lesson
     */
	@ManyToOne
	private Group group;

    /**
     * Teacher
     */
	@ManyToOne
	private Teacher teacher;

    /**
     * Subject that is taught on this lesson
     */
	@ManyToOne
	private Subject subject;


    /**
     * Basic constructor for the TimetableEntry
     * @param time Time at which the lesson is given
     * @param number Number of lesson in the sequence of lessons
     * @param group Group which attends this lesson
     * @param teacher Teacher that teaches this lesson
     * @param subject Subject that is taught on this lesson
     * @param homework Homework for this lesson
     * @param grades Grades assigned to students on this lesson
     */
    public TimetableEntry(Date time, int number, Group group, Teacher teacher,
                          Subject subject, Homework homework, Set<Grade> grades) {
        super();
        this.grades = grades == null ?  new HashSet<Grade>() : grades;
        this.number = number;
        this.time = time;
        this.group = group;
        this.teacher = teacher;
        this.subject = subject;
        this.homework = homework;
    }

    public TimetableEntry(){}

    public boolean isAt(int year, int week)
    {

      Calendar c1 = GregorianCalendar.getInstance();
      Calendar c2 = GregorianCalendar.getInstance();
      Calendar c3 = GregorianCalendar.getInstance();

      c1.setFirstDayOfWeek(Calendar.MONDAY);
      c1.set(Calendar.YEAR,year);
      c1.set(Calendar.WEEK_OF_YEAR,week);
      c1.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);

      c3.setFirstDayOfWeek(Calendar.MONDAY);
      c3.set(Calendar.YEAR, year);
      c3.set(Calendar.WEEK_OF_YEAR,week);
      c3.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);


      c2.setTime(time);
        System.out.println(new Date(c2.getTimeInMillis()).toString());
       // System.out.println("Given timestamp: "+ time.toString());
        System.out.println("Comparing : "+ c1.getTimeInMillis()+" < "+ c2.getTimeInMillis()+" < "+c3.getTimeInMillis());

      return c2.getTimeInMillis() >= c1.getTimeInMillis() && c2.getTimeInMillis() <= c3.getTimeInMillis();
    }



    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

    public int getDayOfTheWeek(){
        cal.setTime(getTime());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

}
