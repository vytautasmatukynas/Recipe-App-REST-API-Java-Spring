package com.example.recipewebsiteapi.repositories;

import com.example.recipewebsiteapi.models.IngredientUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientUnitRepository extends JpaRepository<IngredientUnit, Long> {

    List<IngredientUnit> findByNameContainingIgnoreCase(String unitName);

}
