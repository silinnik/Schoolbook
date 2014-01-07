package models.repositories;
import java.util.*;

import models.BaseModel;
import play.db.ebean.*;
import play.db.ebean.Model.*;

import scala.Option;

public class Repository <T extends BaseModel> {

    private T t;
    private Class<T> classType;

    public Finder<Long,T> find;

    public Repository(Class<T> type){
        classType = type;
        find = new Finder<Long,T>(Long.class, classType );
    }

    public List<T> all(){
        return find
                .where()
                .findList();
    }
    public Option<T> get(Long id){
        return Option(find
                .where().idEq(id)
                .findUnique());
    }
    public void save(T obj){
        if(obj.getId() != null) obj.update();
        else                    obj.save();
    }

    public void delete(Long id){
        find.byId(id).delete();
    }

    protected Option<T> Option(T obj){
        return scala.Option.apply(obj);
    }

}