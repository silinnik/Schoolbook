package models;

import javax.persistence.*;

/**
 * Date: 12/26/13
 */

@Entity
@DiscriminatorValue("TEACHER")
public class MTeacher extends MUser {

    @OneToOne
    private MGroup group;

    public MGroup getGroup() {
        return group;
    }

    public void setGroup(MGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString()+"\n";//+
              //  "Steered group id: "+group.getId();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
