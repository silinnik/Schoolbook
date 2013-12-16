package models.repositories;

import models.Homework;
import models.Subject;
import models.TimetableEntry;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;

/**
 * Date: 12/16/13
 */
public class HomeworkRepository {

    public static Model.Finder<Integer, Homework> find = new Model.Finder<>(Integer.class, Homework.class);

    public static Option<Homework> byId(int subjectId){
        return packToOption(find.byId(subjectId));
    }

    private static Option<Homework> packToOption(Homework homework){
        return homework == null ? ScalaLang.none() : new Some(homework);
    }

}
