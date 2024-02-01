package com.example.recipewebsiteapi.controllers;

import com.example.recipewebsiteapi.services.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

}
