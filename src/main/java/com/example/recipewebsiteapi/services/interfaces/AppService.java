package com.example.recipewebsiteapi.services.interfaces;

import java.util.List;

public interface AppService<T> {

    List<T> getAll();

    T getById(Long id);

    T add(T element);

    T update(Long id, T element);

    String delete(Long id, T element);

}
