package hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GreetingRepositoryTests
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GreetingRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private GreetingRepository greetings;

    @Test
    public void testFindByLastName() {
        Greeting greeting = new Greeting("es", "Hola");
        entityManager.persist(greeting);

        List<Greeting> findByLang = greetings.findByLang(greeting.getLang());

        assertThat(findByLang).extracting(Greeting::getLang).containsOnly(greeting.getLang());
    }    
}