import ch.qos.logback.core.joran.spi.RuleStore;
import controllers.casemodels.UserData;
import models.User;
import models.repositories.UserRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


public class UserRepositoryTest extends WithApplication {

    String existingEmail = "akodev@gmail.com";
    String notExistingEmail = "HaX0R@gmail.com";

    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createUsers(){
        new User(existingEmail,"Akoyan","Developov","@#$%^&*", "Student").save();
    }

    @Test(expected = Exception.class)
    public void createIllegalUser(){
        new User(existingEmail,"Akoyan","Developov","@#$%^&*", "Student").save();

        new User(existingEmail,"Haxor","Ch3a735","Trololo", "Headmaster").save();
    }

    @Test
    public void searchMethodsTest(){
        new User(existingEmail,"Akoyan","Developov","@#$%^&*", "Student").save();

        assertNotNull(UserRepository.find.byId(existingEmail));
        assertNull(UserRepository.find.byId(notExistingEmail));

        assertFalse(UserRepository.isRegistered(notExistingEmail));
        assertTrue(UserRepository.isRegistered(existingEmail));
    }



}
