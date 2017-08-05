package com.recipe.core.service;
import com.recipe.core.config.ConstantAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.recipe.core.domain.User;

@Component
@Path("/users")
public class UserEndpoint implements ConstantAttributes {
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
