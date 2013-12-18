package models;
import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="user_type")
public class User extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String surname;
	
	@Column(nullable=false)
	private String password;

	@Column(name="user_type", nullable=false, updatable=false, insertable=false)
	private String user_type;
	
	public User(String login, String name, String surname, String password) {
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType(){
		return user_type;
	}

    public Teacher asTeacher(){
        return Ebean.find(Teacher.class).where().eq("user_id",getUser_id()).findUnique();
    }

    public Student asStudent(){
        return Ebean.find(Student.class).where().eq("user_id",getUser_id()).findUnique();
    }

    public Headmaster asHeadmaster(){
        return Ebean.find(Headmaster.class).where().eq("user_id",getUser_id()).findUnique();
    }

    public User as(UserRoles role){
        switch(role){
            case H:
                return this.asHeadmaster();
            case T:
                return this.asTeacher();
            case S:
                return this.asStudent();
            case U:
            default:
                return this;
        }
    }

    public User switchTo(UserRoles role){
        User user = this;
        switch(role){
            case H:
                user = new Headmaster(this.getLogin(),this.getName(),this.getSurname(),this.getPassword());
                break;
            case T:
                user = new Teacher(this.getLogin(),this.getName(),this.getSurname(),this.getPassword());
                break;
            case S:
                user = new Student(this.getLogin(),this.getName(),this.getSurname(),this.getPassword());
            default:
                break;
        }
        //TODO add id persistance (from old user to new)
        this.delete();
        user.save();
        return user;

    }

    public User asRoleUser(){
        switch(this.getUserType()){
            case "S" :
                return this.asStudent();
            case "H" :
                return this.asHeadmaster();
            case "T" :
                return this.asTeacher();
            case "U" :
            default :
                return this;
        }
    }

    public void commit(){
        this.save();
    }

	public User(){
	
	}

}
