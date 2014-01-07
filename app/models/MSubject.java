package models;

import javax.persistence.Entity;

/**
 * Date: 12/26/13
 */
@Entity
public class MSubject extends BaseModel {

    public MSubject() {
    }

    public MSubject(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
