package com.diethelper.service;

import com.diethelper.model.CaloricNeedsForm;
import com.diethelper.model.Products;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by iwoha on 6/19/2016.
 */
public interface ProductsService {
    BigDecimal countCaloricNeeds(CaloricNeedsForm caloricNeedsForm);
    List<Products> getDietxMeal(int dietId);
// TESTING ONLY
    List<Products> getIdProducts();
}
