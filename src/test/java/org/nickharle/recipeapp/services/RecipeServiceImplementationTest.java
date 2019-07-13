package org.nickharle.recipeapp.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nickharle.recipeapp.converters.RecipeCommandToRecipe;
import org.nickharle.recipeapp.converters.RecipeToRecipeCommand;
import org.nickharle.recipeapp.domain.Recipe;
import org.nickharle.recipeapp.exceptions.NotFoundException;
import org.nickharle.recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplementationTest {

    RecipeServiceImplementation recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);     // Initialise mocks
        recipeService = new RecipeServiceImplementation(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }


    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() throws Exception {

        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);
        //should go boom
    }

    @Test
    public void getRecipesTest() {

        // Set up HashSet
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet();
        recipeData.add(recipe);

        // Tell Mockito to return recipleData when a call is made to the recipeRepository.findAll
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

        // Verify that the recipeRepository findAll method is called only once
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void deleteByIdTest() throws Exception {

        // given
        Long idToDelete = Long.valueOf(2L);

        // when
        recipeService.deleteById(idToDelete);

        // no when as method has no return type

        // then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }

}