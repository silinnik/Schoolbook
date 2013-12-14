package models;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Headmaster
 *
 */
@Entity
public class Headmaster extends User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int headmaster_id;

	public int getHeadmaster_id() {
		return headmaster_id;
	}

	public void setHeadmaster_id(int headmaster_id) {
		this.headmaster_id = headmaster_id;
	}
   
}
