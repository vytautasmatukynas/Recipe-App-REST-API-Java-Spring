package com.example.recipewebsiteapi.services.interfaces;

import com.example.recipewebsiteapi.models.Ingredient;

import java.util.List;

public interface IngredientService extends AppService<Ingredient> {

    List<Ingredient> searchForIngredient(String ingredientName);

}
