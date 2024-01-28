package com.example.recipewebsiteapi.services.impl;

import com.example.recipewebsiteapi.Repositories.RecipeRepository;
import com.example.recipewebsiteapi.models.Recipe;
import com.example.recipewebsiteapi.services.interfaces.RecipeService;
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
    public Recipe add(Recipe element) {

        return element;
    }

    @Override
    public Recipe update(Long id, Recipe element) {

        return element;
    }

}
