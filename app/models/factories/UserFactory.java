package models.factories;

import models.Headmaster;
import models.Student;
import models.Teacher;
import models.User;

/**
 * Date: 12/16/13
 */
public class UserFactory {
    public User User(String login,String name,String surname,String password,String role){
        switch(role){
            case "S":
                return new Student(login,name,surname,password);
            case "T":
                return new Teacher(login,name,surname,password);
            case "H":
                return new Headmaster(login,name,surname,password);
            case "U":
            default:
                return new User(login,name,surname,password);
        }
    }
}
