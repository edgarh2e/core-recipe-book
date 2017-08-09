package com.recipe.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan({"com.recipe.core"})
@PropertySources({
		@PropertySource("classpath:resources/application.properties"),
		@PropertySource(value = "file:${external.config}", ignoreResourceNotFound = true)
})
public class CoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoreApplication.class);
	}
}
