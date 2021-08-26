package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOM;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOMRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOMRepository unitOMRepository;
    // private RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOMRepository unitOMRepository, RecipeRepository recipeRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOMRepository = unitOMRepository;
        // this.recipeRepository = recipeRepository;

        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        System.out.println("Category Id: " + categoryOptional.get().getId());

        Optional<UnitOM> unitOMOptional = unitOMRepository.findByDescription("Teaspoon");
        System.out.println("Unit of Measure Id: " + unitOMOptional.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
