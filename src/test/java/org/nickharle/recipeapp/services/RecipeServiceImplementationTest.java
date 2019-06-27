package org.nickharle.recipeapp.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nickharle.recipeapp.domain.Recipe;
import org.nickharle.recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplementationTest {

    RecipeServiceImplementation recipeServiceImplementation;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);     // Initialise mocks
        recipeServiceImplementation = new RecipeServiceImplementation(recipeRepository);
    }

    @Test
    public void getRecipes() {

        // Set up HashSet
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet();
        recipeData.add(recipe);

        // Tell Mockito to return recipleData when a call is made to the recipeRepository.findAll
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeServiceImplementation.getRecipes();
        assertEquals(recipes.size(), 1);

        // Verify that the recipeRepository findAll method is called only once
        verify(recipeRepository, times(1)).findAll();
    }
}