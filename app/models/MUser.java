package models;

import javax.persistence.*;

/**
 * Date: 12/23/13
 */


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class MUser extends BaseModel{


    @Column(unique = true,nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Usertype: "+getUserType()+"\n"+
                "Login: "+getLogin()+"\n"+
                "Password: "+getPassword()+"\n"+
                "First Name: "+getFirstName()+"\n"+
                "Last Name: "+getLastName()+"\n";

    }



}
