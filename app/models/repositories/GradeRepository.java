package models.repositories;

import models.Grade;
import models.Group;
import play.db.ebean.Model;

/**
 * Date: 12/16/13
 */
public class GradeRepository {

    public static Model.Finder<Integer, Grade> find = new Model.Finder<>(Integer.class, Grade.class);



}
