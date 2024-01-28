package com.example.recipewebsiteapi.controllers;

import com.example.recipewebsiteapi.services.interfaces.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
}
