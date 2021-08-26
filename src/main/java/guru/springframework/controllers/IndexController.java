package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOM;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOMRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOMRepository unitOMRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOMRepository unitOMRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOMRepository = unitOMRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOM> unitOMOptional = unitOMRepository.findByDescription("Teaspoon");

        System.out.println("Category Id: " + categoryOptional.get().getId());
        System.out.println("Unit of Measure Id: " + unitOMOptional.get().getId());

        return "index";
    }
}
