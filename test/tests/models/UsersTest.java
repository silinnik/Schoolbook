package tests.models;

import com.avaje.ebean.Ebean;
import models.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import models.*;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static java.lang.System.*;

public class UsersTest extends WithApplication {


    /**
     * Sets up environment for each test
     */
    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createTest(){

        out.println("###### User Creation Test #######");


        out.println("   Creating teacher...");

        //Teacher
            Teacher teacher = new Teacher("teacher1","teacher","teacherson","HASHED") ;

        out.println("   Saving teacher...");
            teacher.save();

            //Check values

            assertEquals("teacher1", teacher.getLogin());
            assertEquals("teacher",teacher.getName());
            assertEquals("teacherson",teacher.getSurname());
            assertEquals("HASHED",teacher.getPassword());
            assertEquals("T",teacher.getUserType());

        //Headmaster

        out.println("   Creating headmaster...");
            Headmaster headmaster = new Headmaster("headmaster1","headmaster","headmasterson","HASHED");

        out.println("   Saving headmaster...");
            headmaster.save();


            //Check values

        out.println("   Checking values...");
            assertEquals("headmaster1",headmaster.getLogin());
            assertEquals("headmaster",headmaster.getName());
            assertEquals("headmasterson",headmaster.getSurname());
            assertEquals("HASHED",headmaster.getPassword());
            assertEquals("H",headmaster.getUserType());

        //Student

        out.println("   Creating student...");
            Student student = new Student("student1","student","studentson","HASHED") ;
            student.save();


            //Check values

        out.println("   Checking students...");
            assertEquals("student1",student.getLogin());
            assertEquals("student",student.getName());
            assertEquals("studentson",student.getSurname());
            assertEquals("HASHED",student.getPassword());
            assertEquals("S",student.getUserType());



        out.println("   Checking inheritance on Headmaster");
        //Check if Headmaster exists as User, as Headmaster and does not exist as Teacher or Student
        headmaster = Ebean.find(Headmaster.class).where().eq("user_id",headmaster.getUser_id()).findUnique();
        assertNotNull(headmaster);
        assertNotNull(Ebean.find(User.class).where().eq("user_id",headmaster.getUser_id()).findUnique());
        assertNull(Ebean.find(Teacher.class).where().eq("user_id",headmaster.getUser_id()).findUnique());
        assertNull(Ebean.find(Student.class).where().eq("user_id",headmaster.getUser_id()).findUnique());

        out.println("   Checking inheritance on Teacher");
        //Check if Teacher exists as User, as Teacher and does not exist as Headmaster or Student
        teacher = Ebean.find(Teacher.class).where().eq("user_id",teacher.getUser_id()).findUnique();
        assertNotNull(teacher);
        assertNotNull(Ebean.find(User.class).where().eq("user_id",teacher.getUser_id()).findUnique());
        assertNull(Ebean.find(Headmaster.class).where().eq("user_id",teacher.getUser_id()).findUnique());
        assertNull(Ebean.find(Student.class).where().eq("user_id",teacher.getUser_id()).findUnique());

        out.println("   Checking inheritance on Student");
        //Check if Student exists as User, as Student and does not exist as Teacher or Headmaster
        student = Ebean.find(Student.class).where().eq("user_id",student.getUser_id()).findUnique();
        assertNotNull(student);
        assertNotNull(Ebean.find(User.class).where().eq("user_id",student.getUser_id()).findUnique());
        assertNull(Ebean.find(Teacher.class).where().eq("user_id",student.getUser_id()).findUnique());
        assertNull(Ebean.find(Headmaster.class).where().eq("user_id",student.getUser_id()).findUnique());

    }

    @Test
    public void readTest(){

    }

    @Test
    public void deleteTest(){

    }

    @Test
    public void updateTest(){

    }

}
