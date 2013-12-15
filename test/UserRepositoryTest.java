
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

    String existingEmail = "akodev@gmail.com";
    String notExistingEmail = "HaX0R@gmail.com";

    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createUsers(){
        System.out.println("Testing DB...");

        Teacher a = new Teacher("silinnik","Nikita","Silin","HASHED");

        Headmaster b = new Headmaster("silinnik2","Nikita","Silin","HASHED");

        a.save();
        b.save();

        assertNotNull(Ebean.find(User.class).where().eq("login",a.getLogin()));

    }




}
