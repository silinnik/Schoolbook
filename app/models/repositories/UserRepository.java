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

    public static Model.Finder<Integer, User> find = new Model.Finder<>(Integer.class, User.class);

    public static List<User> all() {
        return find.all();
    }

    public static void commit(User user) {
        if(find.byId(user.getUser_id()) == null)
        user.save();
        else
        user.update();
    }

    public static void removeUser(Integer userId){
        User user = find.byId(userId);
        if(user!=null) user.delete();
    }

    public static Option<User> findById(Integer userId){
        User user = find.byId(userId);
        if(user!=null)
            return new Some(user);
        else
            return ScalaLang.none();

    }

    public static Option<User> findByLogin(String userLogin){
        User user = find.where().eq("login",userLogin).findUnique();
        if(user!=null)
            return new Some(user);
        else
            return ScalaLang.<User>none();

    }

    public static boolean isRegistered(String userLogin){
        return findByLogin(userLogin) != null;
    }

}
