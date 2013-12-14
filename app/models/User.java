package models;
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
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int user_id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String surname;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private char user_type;
	
	public User(String login, String name, String surname, String password, char user_type) {
		this.user_type = user_type;
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

	public char getUser_type() {
		return user_type;
	}

	public void setUser_type(char user_type) {
		this.user_type = user_type;
	}
	
	
   
}
