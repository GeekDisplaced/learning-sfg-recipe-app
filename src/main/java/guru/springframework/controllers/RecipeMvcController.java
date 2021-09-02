package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/recipe"})
public class RecipeMvcController {

    private final RecipeService recipeService;

    public RecipeMvcController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/show/{id}"})
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));

        return "recipe/show";
    }

    @RequestMapping({"/new"})
    public String newRecipe(Model model) {

        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/upsert";
    }

    // Legacy style
    // @RequestMapping(name = "recipe", method = Request.method.POST)
    @PostMapping
    @RequestMapping({"", "/"})
    public String upsertRecipe(@ModelAttribute RecipeCommand recipeCommand) {

        RecipeCommand savedCommand = recipeService.saveRecipeCommand((recipeCommand));

        return "redirect:/recipe/show/" + savedCommand.getId();
    }
}
