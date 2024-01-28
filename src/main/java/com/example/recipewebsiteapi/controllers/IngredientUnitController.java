package com.example.recipewebsiteapi.controllers;

import com.example.recipewebsiteapi.services.interfaces.IngredientUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class IngredientUnitController {

    private final IngredientUnitService ingredientUnitService;

}
