package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    @Test
    public void testFindByLastName() {

        // Lege neuen User an
        User user = new User("first", "last");

        // Speichere User
        entityManager.persist(user);

        // Suche User über den Nachnamen aus der Datenbank
        List<User> findByLastName = users.findByLastName(user.getLastName());

        // Vergleiche Namen des angelegten User mit dem abgespeicherten User
        assertThat(findByLastName).extracting(User::getLastName).containsOnly(user.getLastName());
    }
}