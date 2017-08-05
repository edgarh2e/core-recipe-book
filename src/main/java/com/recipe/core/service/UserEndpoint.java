package com.recipe.core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.recipe.core.domain.User;

@Component
@Path("/users")
public class UserEndpoint {
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_HEADER = "Access-Control-Allow-Headers";
    private static final String ASTERISK = "*";
    private static final String METHODS = "GET, POST";
    private static final String HEADERS = "Content-Type, Authorization, Accept, X-Requested-With";
    @Autowired
    private UserService userService;

    @GET
    @Path("/getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() throws Exception {
        return this.generarRespuesta(this.userService.getUsers());
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
