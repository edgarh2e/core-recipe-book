package com.recipe.core.service;

import com.recipe.core.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setDescription("Bread");
        recipe.setName("Bread");
        recipe.setImageUrl("https://static01.nyt.com/images/2017/02/16/dining/16COOKING-NOKNEADBREAD1/16COOKING-NOKNEADBREAD1-videoSixteenByNineJumbo1600.jpg");
        recipes.add(recipe);
        return recipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }
}
