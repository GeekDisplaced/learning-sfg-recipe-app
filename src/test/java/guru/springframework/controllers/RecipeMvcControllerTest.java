package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeMvcControllerTest {

    @Mock
    RecipeService recipeService;

    // code under test
    RecipeMvcController recipeMvcController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeMvcController = new RecipeMvcController((recipeService));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showById() throws Exception {

        // mock data
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeMvcController).build();

        // mock behaviour
        when(recipeService.findRecipeById( anyLong()) ).thenReturn(recipe);

        // code under test
        mockMvc.perform(get("/recipe/show/1"))
                // test assertions
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}