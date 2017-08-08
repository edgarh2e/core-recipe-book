package com.recipe.core.service;

import com.recipe.core.domain.Recipe;
import com.recipe.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeEntity> recipesEntities = recipeDao.findAll();
        for (RecipeEntity recipeEntity : recipesEntities) {
            Recipe recipe = new Recipe();
            recipe.setId(recipeEntity.getId());
            recipe.setDescription(recipeEntity.getDescription());
            recipe.setName(recipeEntity.getName());
            recipe.setImageUrl(recipeEntity.getImageUrl());
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }
}
