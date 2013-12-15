
import com.avaje.ebean.Ebean;
import models.User;
import models.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import models.*;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


public class UserRepositoryTest extends WithApplication {

    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createUsers(){

    }




}
