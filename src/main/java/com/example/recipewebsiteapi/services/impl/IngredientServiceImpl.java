package com.example.recipewebsiteapi.services.impl;

import com.example.recipewebsiteapi.repositories.IngredientRepository;
import com.example.recipewebsiteapi.models.Ingredient;
import com.example.recipewebsiteapi.services.interfaces.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Ingredient not found"));
    }

    @Override
    public Ingredient add(Ingredient ingredient) {
        Ingredient newIngredient = new Ingredient(ingredient.getName());

        ingredientRepository.save(newIngredient);

        return newIngredient;
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        Ingredient existingIngredient = getById(id);

        existingIngredient.setName(ingredient.getName());

        ingredientRepository.save(existingIngredient);

        return existingIngredient;
    }

    @Override
    public String delete(Long id, Ingredient element) {
        Ingredient ingredientToDelete = getById(id);

        ingredientRepository.delete(ingredientToDelete);

        return "Ingredient deleted successfully";
    }

    @Override
    public List<Ingredient> searchForIngredient(String ingredientName) {
        return ingredientRepository.findByNameContainingIgnoreCase(ingredientName);
    }

}
