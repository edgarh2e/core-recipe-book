package com.recipe.core.service

import com.recipe.core.domain.Recipe
import org.junit.runners.AllTests
import spock.lang.Specification
import com.recipe.core.repository.*
import spock.lang.Unroll

class RecipeServiceImplTest extends Specification {

    RecipeService recipeService = new RecipeServiceImpl()

    @Unroll("Get recipes #_recipesMock")
    def "Get Recipes"() {
        given:"Dado lo siguiente"
            def recipes
            def recipesMock = _recipesMock
        and:"y"
            def recipeDaoMock = Mock(RecipeDao)
            recipeService.recipeDao = recipeDaoMock
        when:"cuando"
            recipes = recipeService.getRecipes()
        then:"entonces"
            1 * recipeDaoMock.findAll() >> recipesMock
            assert recipes.size() > 0
        where:"donde"
            _recipesMock << [
                    [new RecipeEntity(id: 1, name: "nombre 1",
                            description: "Receta 1",
                            imageUrl: "http://ww.prueba1.com")],
                    [new RecipeEntity(id: 2, name: "nombre 2",
                            description: "Receta 2",
                            imageUrl: "http://ww.prueba2.com")]
            ]
    }

    def "Add Recipe"() {
        given:"Dado lo siguiente"
            def recipeDaoMock = Mock(RecipeDao)
            recipeService.recipeDao = recipeDaoMock
            Recipe newRecipe = new Recipe()
        and:"y"
            newRecipe.id=5
            newRecipe.name="receta 5"
            newRecipe.description="receta 5"
            newRecipe.imageUrl="www.url5.com.mx"
        when:"cuando"
            recipeService.addRecipe(newRecipe)
        then:"entonces"
            1 * recipeDaoMock.saveAndFlush(_)
    }
}
