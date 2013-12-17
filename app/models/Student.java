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
   
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
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
		return student_id;
	}

    /**
     * Sets the student id
     * @param student_id
     */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
    }

    /**
     * Returns "S"
     * @return "S"
     */
    @Override
    public String getUserType(){
          return "S";
    }

    /**
     * Returns the group, student belongs to
     * @return Optional value which may contain the
     */
    public Option<Group> getGroup(){
       return GroupRepository.byStudent(this);
    }

	@ManyToOne
	private Group group;

//	public Group getGroup(){
//	return this.group;
//	}

	public void setGroup(Group group){
	this.group = group;
	}
	
}


	


