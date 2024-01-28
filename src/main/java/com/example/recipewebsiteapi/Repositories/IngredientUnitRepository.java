package com.example.recipewebsiteapi.Repositories;

import com.example.recipewebsiteapi.models.IngredientUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientUnitRepository extends JpaRepository<IngredientUnit, Long> {
}
