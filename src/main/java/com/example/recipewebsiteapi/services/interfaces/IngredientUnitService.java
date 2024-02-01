package com.example.recipewebsiteapi.services.interfaces;

import com.example.recipewebsiteapi.models.IngredientUnit;

import java.util.List;

public interface IngredientUnitService extends AppService<IngredientUnit> {

    List<IngredientUnit> searchForUnit(String unitName);

}
