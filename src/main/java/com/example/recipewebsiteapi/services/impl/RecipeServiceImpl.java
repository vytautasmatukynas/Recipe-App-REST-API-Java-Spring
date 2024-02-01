package com.example.recipewebsiteapi.services.impl;

import com.example.recipewebsiteapi.models.RecipeIngredient;
import com.example.recipewebsiteapi.models.RecipeInstruction;
import com.example.recipewebsiteapi.repositories.RecipeRepository;
import com.example.recipewebsiteapi.models.Recipe;
import com.example.recipewebsiteapi.services.interfaces.RecipeService;
import com.example.recipewebsiteapi.utils.GenerateDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getById(Long id) {
        return recipeRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Recipe not found"));
    }

    @Override
    public Recipe add(Recipe recipe) {
        recipe.setUpdateDate(GenerateDate.generateCurrentDate());

        recipeRepository.save(recipe);

        return recipe;
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Recipe not found."));

        existingRecipe.setRecipeName(recipe.getRecipeName());
        existingRecipe.setDishType(recipe.getDishType());
        existingRecipe.setPrepTime(recipe.getPrepTime());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setInstructions(recipe.getInstructions());
        existingRecipe.setLinkToImg(recipe.getLinkToImg());
        existingRecipe.setUpdateDate(GenerateDate.generateCurrentDate());

        recipeRepository.save(existingRecipe);

        return existingRecipe;
    }

    @Override
    public String delete(Long id, Recipe element) {
        Recipe recipeToDelete = getById(id);

        recipeRepository.delete(recipeToDelete);

        return "Recipe deleted successfully: " + recipeToDelete.getRecipeName();
    }

    @Override
    public List<Recipe> searchForRecipe(String searchParam) {
        return recipeRepository.
                findAllByDishTypeContainingIgnoreCaseAndRecipeNameContainingIgnoreCase(
                        searchParam, searchParam);
    }

    @Override
    public RecipeInstruction addInstruction(Long id, RecipeInstruction instruction) {
        Recipe recipe = getById(id);

        recipe.addInstructions(instruction);

        recipeRepository.save(recipe);

        return instruction;
    }

    @Override
    public RecipeIngredient addIngredient(Long id, RecipeIngredient ingredient) {
        Recipe recipe = getById(id);

        recipe.addIngredient(ingredient);

        recipeRepository.save(recipe);

        return ingredient;
    }

    @Override
    public String removeInstruction(Long id, String name) {
        Recipe recipe = getById(id);

        List<RecipeInstruction> existingInstructions = recipe.getInstructions();

        existingInstructions.removeIf(instruction -> instruction.getText().equalsIgnoreCase(name));

        recipeRepository.save(recipe);

        return "Instruction removed successfully: " + name;
    }

    @Override
    public String removeIngredient(Long id, String name) {
        Recipe recipe = getById(id);

        List<RecipeIngredient> existingIngredients = recipe.getIngredients();

        existingIngredients.removeIf(ingredient -> ingredient.getName().equalsIgnoreCase(name));

        recipeRepository.save(recipe);

        return "Ingredient removed successfully: " + name;
    }

}
