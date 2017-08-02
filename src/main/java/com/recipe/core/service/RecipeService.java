package com.recipe.core.service;

import com.recipe.core.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();

    void addRecipe(Recipe recipe);
}
