package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Date: 12/23/13
 */
@Entity
@DiscriminatorValue("STUDENT")
public class MStudent extends MUser{

    @ManyToOne
    private MGroup group;

    public MGroup getGroup() {
        return group;
    }

    public void setGroup(MGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString()+"\n";/*+
                "Group ID: "+getGroup().getId()+"\n"+
                "Group Name: "+getGroup().getName();*/
    }

}
