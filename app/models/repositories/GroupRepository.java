package models.repositories;

import models.Group;
import models.Student;
import models.User;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides static methods for searching and manipulation the student groups.
 */
public class GroupRepository {

    public static Model.Finder<Integer, Group> find = new Model.Finder<>(Integer.class, Group.class);

    /**
     * Return the group with the given id
     * @param id of the group
     * @return Optional value that may contain the Group with the given id
     */
    public static Option<Group> byId(int id){
        return packToOption(find.where().idEq(id).findUnique());
    }

    /**
     * Retrieves the group by name
     * @param name of the group
     * @return Optional value that may contain the Group with the given name
     */
    public static Option<Group> byName(String name){
        return packToOption( find.where().eq("name",name).findUnique());
    }

    /**
     * Retrieves all the groups that present in the database
     * @return Set of all the groups
     */
    public static Set<Group> all(){
        return new HashSet<>(find.all());
    }

    /**
     * Looks for a group contatining the given student
     * @param student
     * @return Optional values which may contain the Group with the given student
     */
    public static Option<Group> byStudent(Student student){
        Group resGroup = null;

        for(Group group : all())
            if(group.hasStudent(student))
                resGroup = group;

        return packToOption(resGroup);
    }

    /**
     * This method packs the group value (which may be null) into the Option<Group> type for usage with Scala
     * @param group
     * @return
     */
    private static Option<Group> packToOption(Group group){
        return group == null ? ScalaLang.none() : new Some(group);
    }

}
