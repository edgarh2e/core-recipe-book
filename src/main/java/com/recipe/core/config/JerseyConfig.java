package com.recipe.core.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

import com.recipe.core.service.RecipeEndpoint;
import com.recipe.core.service.UserEndpoint;

@Configuration
@ApplicationPath("/service")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() { registerEndpoints(); }

    private void registerEndpoints() {
        register(RecipeEndpoint.class);
        register(UserEndpoint.class);
    }
}
