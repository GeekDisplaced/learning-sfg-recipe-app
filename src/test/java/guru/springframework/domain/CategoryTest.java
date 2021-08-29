package guru.springframework.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {

        category = new Category();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        Long idValue = 4l;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }

    @Test
    public void setId() {

    }

    @Test
    public void setDescription() {
    }

    @Test
    public void setRecipes() {
    }
}