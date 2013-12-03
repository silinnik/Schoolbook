package models.repositories;

import models.User;
import play.data.Form;
import play.db.ebean.Model;

import java.util.List;

/**
 * Date: 12/2/13
 */
public class UserRepository {

    public static Model.Finder<String, User> find = new Model.Finder<String, User>(String.class, User.class);

    public static List<User> all() {
        return find.all();
    }

    public static void commit(User user) {
        user.save();
    }

    public static Form<User> getForm() {
        return Form.form(User.class);
    }

}
