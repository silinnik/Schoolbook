package models.repositories;

import models.Grade;
import models.TimetableEntry;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;

import java.sql.Date;

/**
 * Date: 12/16/13
 */
public class TimetableEntryRepository {

    public static Model.Finder<Integer, TimetableEntry> find = new Model.Finder<>(Integer.class, TimetableEntry.class);

    public static Option<TimetableEntry> byId(int timetableEntryId){
       return packInOption(find.byId(timetableEntryId));
    }

    public static Option<TimetableEntry> byDate(Date date){
       return packInOption(find.where().eq("date",date.toString()).findUnique());
    }

    public static Option<TimetableEntry> byGrade(Grade grade){
        for(TimetableEntry entry : find.all()){
            for(Grade gradeInEntry : entry.getGrades()){
                if(gradeInEntry.getGrade_id() == grade.getGrade_id())
                    return new Some(entry);
            }
        }
        return ScalaLang.none();
    }

    private static Option<TimetableEntry> packInOption(TimetableEntry entry){
        return entry == null ? ScalaLang.none() : new Some(entry);
    }

}
