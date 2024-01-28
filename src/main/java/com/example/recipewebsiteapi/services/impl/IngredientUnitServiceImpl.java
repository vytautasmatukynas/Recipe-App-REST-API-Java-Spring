package com.example.recipewebsiteapi.services.impl;

import com.example.recipewebsiteapi.Repositories.IngredientUnitRepository;
import com.example.recipewebsiteapi.models.IngredientUnit;
import com.example.recipewebsiteapi.services.interfaces.IngredientUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IngredientUnitServiceImpl implements IngredientUnitService {

    private final IngredientUnitRepository ingredientUnitRepository;

    @Override
    public List<IngredientUnit> getAll() {
        return ingredientUnitRepository.findAll();
    }

    @Override
    public IngredientUnit getById(Long id) {
        return ingredientUnitRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Unit not found"));
    }

    @Override
    public IngredientUnit add(IngredientUnit ingredientUnit) {
        IngredientUnit newIngredientUnit = new IngredientUnit(ingredientUnit.getName());

        ingredientUnitRepository.save(newIngredientUnit);

        return newIngredientUnit;
    }

    @Override
    public IngredientUnit update(Long id, IngredientUnit ingredientUnit) {
        IngredientUnit oldIngredientUnit = getById(id);

        oldIngredientUnit.setName(ingredientUnit.getName());

        ingredientUnitRepository.save(oldIngredientUnit);

        return oldIngredientUnit;
    }

}
