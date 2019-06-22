package org.nickharle.recipeapp.services;

import org.nickharle.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

}
