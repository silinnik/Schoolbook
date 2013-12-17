package scalalang;

import scala.None$;
import scala.Option;

/**
 * Date: 12/3/13
 */

public class ScalaLang {

    public static <T> Option<T> none() {
        return (Option<T>) None$.MODULE$;
    }
}