
import com.avaje.ebean.Ebean;
import models.MStudent;
import models.MUser;
import models.repositories.MUsersRepository;
import models.repositories.Repository;
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

        testdata.TestDataProvider.InitializeDatabaseWithDefaultValues();



        /// Ebean.save((List) Yaml.load("SchoolTest.yml"));






    }

    @Test
    public void createUsers(){


    }




}
