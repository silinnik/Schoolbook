
import com.avaje.ebean.Ebean;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import play.libs.Yaml;
import play.test.WithApplication;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


public class UserRepositoryTest extends WithApplication {

    @Before
    public void setUp(){

        start(fakeApplication(inMemoryDatabase()));

         Ebean.save((List) Yaml.load("SchoolTest.yml"));

    }

    @Test
    public void createUsers(){

    }




}
