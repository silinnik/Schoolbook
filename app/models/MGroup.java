package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Date: 12/23/13
 */

@Entity
public class MGroup extends BaseModel{

    private String name;

    public MGroup() {
    }

    public MGroup(String name) {
        this.name = name;
    }

    @OneToOne
    private MTeacher mentor;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    private Set<MStudent> students;

    public MTeacher getMentor() {
        return mentor;
    }

    public void setMentor(MTeacher mentor) {
        this.mentor = mentor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<MStudent> students) {
        for(MStudent student : students){
            student.setGroup(this);
        }

        this.students = students;
    }

    public void addStudent(MStudent student){
       this.getStudents().add(student);
       student.setGroup(this);
    }


    @Override
    public String toString() {

        String res = super.toString()+"\n";

        res+="Name: "+getName()+"\n";
        res+="Mentor: "+getMentor().getLogin()+"\n";
        for(MStudent student : getStudents()){
            res+="      "+student.getLogin()+"\n";
        }

        return res;
    }
}
