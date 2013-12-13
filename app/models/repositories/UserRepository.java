package models.repositories;

import models.User;
import play.db.ebean.Model;
import scala.Option;
import scala.Some;
import scalalang.ScalaLang;

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
        if(find.byId(user.email) == null)
        user.save();
        else
        user.update();
    }

    public static void removeUser(String email){
        User user = find.byId(email);
        if(user!=null) user.delete();
    }

    public static Option<User> findByEmail(String email){
        User user = find.byId(email);
        if(user!=null)
            return new Some(user);
        else
            return ScalaLang.<User>none();

    }

    public static boolean isRegistered(String email){
        return find.byId(email) != null;
    }

}
