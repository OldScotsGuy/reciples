package org.nickharle.recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.nickharle.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Take id out of URL i.e GET equivalent
    @RequestMapping("/recipe/show{id}")
    // Pass id into method
    public String showByID(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

}
