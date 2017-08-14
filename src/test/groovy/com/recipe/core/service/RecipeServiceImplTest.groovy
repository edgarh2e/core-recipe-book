package com.recipe.core.service

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
    }
}
