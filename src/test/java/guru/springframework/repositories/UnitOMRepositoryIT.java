package guru.springframework.repositories;

import guru.springframework.domain.UnitOM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOMRepositoryIT {

    @Autowired
    UnitOMRepository unitOMRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByDescription_Teaspoon() {

        UnitOM unitOM = unitOMRepository.findByDescription("Teaspoon").orElse(null);

        assertEquals("Teaspoon", unitOM.getDescription());
    }

    @Test
    public void findByDescription_Cup() {

        UnitOM unitOM = unitOMRepository.findByDescription("Cup").orElse(null);

        assertEquals("Cup", unitOM.getDescription());
    }

    @Test
    public void findByDescription_Envelope() {

        UnitOM UnitOM = unitOMRepository.findByDescription("Envelope").orElse(null);

        assertNull(UnitOM);
    }
}