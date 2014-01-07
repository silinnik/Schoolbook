package models;

import play.db.ebean.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Date: 12/23/13
 */

@MappedSuperclass
public abstract class BaseModel extends Model {

    @Id @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName()+"\n" +
                "Id: "+getId();
    }

}
