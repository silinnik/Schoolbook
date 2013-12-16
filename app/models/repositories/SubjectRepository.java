package models.repositories;

import models.Subject;
import models.TimetableEntry;
import models.User;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;

/**
 * Date: 12/16/13
 */
public class SubjectRepository {

    public static Model.Finder<Integer, Subject> find = new Model.Finder<>(Integer.class, Subject.class);

    public static Option<Subject> byId(int subjectId){
        return packToOption(find.byId(subjectId));
    }

    public static Option<Subject> byName(String subjectName){
        return packToOption(find.where().eq("name",subjectName).findUnique());
    }

    private static Option<Subject> packToOption(Subject subject){
        return subject == null ? ScalaLang.none() : new Some(subject);
    }


}
