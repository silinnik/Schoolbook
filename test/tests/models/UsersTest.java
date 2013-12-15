package tests.models;

import com.avaje.ebean.Ebean;
import models.User;
import models.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import models.*;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


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

        //Teacher
            Teacher teacher = new Teacher("teacher1","teacher","teacherson","HASHED") ;
            teacher.save();


            //Check values
            assertEquals("teacher1",teacher.getLogin());
            assertEquals("teacher",teacher.getName());
            assertEquals("teacherson",teacher.getSurname());
            assertEquals("HASHED",teacher.getPassword());
            assertEquals("T",teacher.getType());


        //Headmaster
            Headmaster headmaster = new Headmaster("headmaster1","headmaster","headmasterson","HASHED") ;
            headmaster.save();


            //Check values
            assertEquals("headmaster1",headmaster.getLogin());
            assertEquals("headmaster",headmaster.getName());
            assertEquals("headmasterson",headmaster.getSurname());
            assertEquals("HASHED",headmaster.getPassword());
            assertEquals("H",headmaster.getType());

        //Student
            Student student = new Student("student1","student","studentson","HASHED") ;
            student.save();


            //Check values
            assertEquals("student1",student.getLogin());
            assertEquals("student",student.getName());
            assertEquals("studentson",student.getSurname());
            assertEquals("HASHED",student.getPassword());
            assertEquals("S",student.getType());


        //Check if Headmaster exists as User, as Headmaster and does not exist as Teacher or Student
        headmaster = Ebean.find(Headmaster.class).where().eq("user_id",headmaster.getUser_id()).findUnique();
        assertNotNull(headmaster);
        assertNotNull(Ebean.find(User.class).where().eq("user_id",headmaster.getUser_id()).findUnique());
        assertNull(Ebean.find(Teacher.class).where().eq("user_id",headmaster.getUser_id()).findUnique());
        assertNull(Ebean.find(Student.class).where().eq("user_id",headmaster.getUser_id()).findUnique());

        //Check if Teacher exists as User, as Teacher and does not exist as Headmaster or Student
        teacher = Ebean.find(Teacher.class).where().eq("user_id",teacher.getUser_id()).findUnique();
        assertNotNull(teacher);
        assertNotNull(Ebean.find(User.class).where().eq("user_id",teacher.getUser_id()).findUnique());
        assertNull(Ebean.find(Headmaster.class).where().eq("user_id",teacher.getUser_id()).findUnique());
        assertNull(Ebean.find(Student.class).where().eq("user_id",teacher.getUser_id()).findUnique());

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
