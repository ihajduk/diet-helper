package com.diethelper.service;

import com.diethelper.model.CaloricNeedsForm;
import com.diethelper.model.Diets;
import com.diethelper.model.Meals;
import com.diethelper.model.Products;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by iwoha on 6/19/2016.
 */
public interface FoodService {
    BigDecimal countCaloricNeeds(CaloricNeedsForm caloricNeedsForm);
    List<Products> getDietxMeal(int dietId);
// TESTING ONLY
    List<Products> getIdProducts();
    void saveProduct(Products product);
    void saveMeal(Meals meal);
    void saveDiet(Diets diet);
}
