package models;	

import com.avaje.ebean.Ebean;
import models.repositories.GroupRepository;
import scala.Option;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@DiscriminatorValue("S")
public class Student extends User {

	public Student(String login, String name, String surname, String password){

        super(login, name, surname, password);

/*        Calendar cal = new GregorianCalendar(2013, 9, 2);
        System.out.println("Calendar shows year: "+cal.get(Calendar.YEAR));
        Date fuckingDate = new Date(cal.getTimeInMillis());
        System.out.println("Date shows year: "+fuckingDate.getYear());
        System.out.println("Date as string: "+fuckingDate.toString());
        System.out.println("Calendar as string: "+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        cal = Calendar.getInstance();
        cal.setTime(fuckingDate);
        System.out.println("Calendar made of date shows year: "+cal.get(Calendar.YEAR));
        System.out.println("Calendar made of date as string: "+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH));*/

    }

	public Student(){}

    /**
     * retrieves the student it
     * @return int representing student id
     */
	public int getStudent_id() {
		return getUser_id();
	}

    /**
     * Sets the student id
     * @param student_id
     */
	public void setStudent_id(int student_id) {
		this.setUser_id(student_id);
    }

    /**
     * Returns "S"
     * @return "S"
     */

    /**
     * Returns the group, student belongs to
     * @return Optional value which may contain the
     */
    @Column
	private int group_id;

	public Group getGroup(){
	    return Ebean.find(Group.class).where().idEq(this.group_id).findUnique();
	}

	public void setGroup(int group){
	    this.group_id = group;
	}
	
}


	


