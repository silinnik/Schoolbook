package models;

import controllers.casemodels.UserData;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Date: 12/2/13
 */
@Entity
public class User extends Model {
    public User(String email, String name, String surname, String password, String role) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    @Id

    public String email;
    public String name;
    public String surname;
    public String password;
    public String role;

}
