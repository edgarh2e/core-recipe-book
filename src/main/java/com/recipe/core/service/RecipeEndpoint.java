package com.recipe.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.recipe.core.domain.Recipe;

@Component
@Path("/recipes")
public class RecipeEndpoint {

    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_HEADER = "Access-Control-Allow-Headers";
    private static final String ASTERISK = "*";
    private static final String METHODS = "GET, POST";
    private static final String HEADERS = "Content-Type, Authorization, Accept, X-Requested-With";

    @Autowired
    private RecipeService recipeService;

    @GET
    @Path("/getRecipes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes() throws Exception {
        return this.generarRespuesta(this.recipeService.getRecipes());
    }

    @POST
    @Path("/addRecipe")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRecipe(Recipe recipe) throws Exception {
        this.recipeService.addRecipe(recipe);
        return this.generarRespuesta(recipe);
    }

    private Response generarRespuesta(Object objeto) {
        return Response
                .status(201)
                .entity(objeto)
                .header(ACCESS_CONTROL_ALLOW_ORIGIN, ASTERISK)
                .header(ACCESS_CONTROL_ALLOW_METHODS, METHODS)
                .header(ACCESS_CONTROL_ALLOW_HEADER, HEADERS)
                .build();
    }

}
