package models.repositories;

import com.avaje.ebean.Ebean;
import models.*;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date: 12/2/13
 */
public class UserRepository {

    public static Model.Finder<Integer, User> find = new Model.Finder<>(Integer.class, User.class);

    /**
     * Gets a set of all the user present in the database
     * @return Set of all the users.
     */
    public static Set<User> all() {
        return new HashSet<>(find.all());
    }

    /**
     * Gets a set of all the students present in the database
     * @return Set of all the students.
     */
    public static Set<Student> allStudents() {
        return new HashSet<>(Ebean.find(Student.class).findSet());
    }

    /**
     * Gets a set of all the students with given ids
     * @param ids list of ids to look for
     * @return Set of all the students which have index mantioned in the list.
     */
    public static Set<Student> byStudentIds(List<Integer> ids) {
        return Ebean.find(Student.class).where().idIn(ids).findSet();
    }

    /**
     * Gets a set of all the teachers present in the database
     * @return Set of all the teachers.
     */
    public static Set<Teacher> allTeachers() {
        return new HashSet<>(Ebean.find(Teacher.class).findSet());
    }

    /**
     * Gets a set of all the headmasters present in the database
     * @return Set of all the headmasters.
     */
    public static Set<Headmaster> allHeadmasters() {
        return new HashSet<>(Ebean.find(Headmaster.class).findSet());
    }

    /**
     * Test method to check if it may replace the methods for allStudents, allTeachers...
     * @param type type of the desired User
     * @param <T>  type of the desired User
     * @return
     */
    public static <T extends User> Set<T> all(Class type){
        return new HashSet<T>(Ebean.find(type).findSet());
    }

    /**
     * Removes the given user from the database
     * @param user object to remove
     */
    public static void removeUser(User user){
        if(user!=null) user.delete();
    }

    /**
     * Removes the user from the database by user id
     * @param userId Id of the user to remove
     */
    public static void removeUser(Integer userId){
        removeUser(find.byId(userId));
    }

    /**
     * Gets user by his id
     * @param userId User id to look for
     * @return Optional values which may contain the user with given id
     */
    public static Option<User> findById(Integer userId){
        return packToOption(Ebean.find(User.class).where().idEq(userId).findUnique());
    }


    public static Option<Teacher> findTeacherById(Integer teacherId){
        return packAnyToOption(Ebean.find(Teacher.class).where().idEq(teacherId).findUnique());
    }

    /**
     * Gets user by his login
     * @param userLogin User name to look for
     * @return Optional Values which may contain the user with given login
     */
    public static Option<User> findByLogin(String userLogin){

        return packToOption(Ebean.find(User.class).where().eq("login", userLogin).findUnique());

    }

    /**
     * Checks if login is already registered in the system
     * @param userLogin login to check
     * @return True if login is registered in the system. Flase otherwise
     */
    public static boolean isLoginRegistered(String userLogin){
        return !findByLogin(userLogin).isEmpty();
    }

    private static Option<User> packToOption(User user){
        return user == null ? ScalaLang.none() : new Some(user);
    }

    private static <T> Option<T> packAnyToOption(T object){
        return object == null ? ScalaLang.none() : new Some(object);    }

}
