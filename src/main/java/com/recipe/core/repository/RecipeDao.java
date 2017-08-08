package com.recipe.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<RecipeEntity, Long> {
}
