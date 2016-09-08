package com.diethelper.service;

import com.diethelper.model.CaloricNeedsForm;
import com.diethelper.model.Products;
import com.diethelper.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by iwoha on 7/25/2016.
 */

/**
 * mężczyzna: 180 cm, 60 kg, masa
 * <p>
 * TDEE = BMR + TEA + TEF + NEAT
 * <p>
 * BMR= (9.99 X waga (kg)) + (6.25 X wzrost (cm)) - (4.92 X wiek) + 5
 * <p>
 * BMR = (9.99 X 60 (kg)) + (6.25 X 180 (cm)) - (4.92 X 20) + 5 = 1631 kcal
 * TEA = 3 x 45 (min) x 9 + 3 x 7% x 1631 = 1558 kcal
 * 1558 kcal / 223 kcal
 * <p>
 * BMR + TEA = 1854 kcal
 * <p>
 * + NEAT (900 kcal) = 1854 kcal + 900 kcal = 2754 kcal
 * <p>
 * + TEF (10% x ALL) = 2754 kcal + 10% x 2754 kcal = 3029 kcal
 * <p>
 * TDEE = 3029 kcal
 */

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public BigDecimal countCaloricNeeds(CaloricNeedsForm caloricNeedsForm) {
        int trainingsPerWeek = 3;
        int trainingDuration = 45;
        int unknownMultiplier = 9;
        double percentage = 0.07;
        int neat = 900;

        double bmr = (9.99 * caloricNeedsForm.getWeight())
                        + (6.25 * caloricNeedsForm.getHeight())
                        - (4.92 * caloricNeedsForm.getAge()) + 5;

        double tea = ((trainingsPerWeek * trainingDuration * unknownMultiplier)
                        + (trainingsPerWeek * percentage * bmr)) /7 ;

        double tef = 0.1 * (bmr + tea + neat);

        BigDecimal tdee = BigDecimal.valueOf(bmr+tea+neat+tef).setScale(2,BigDecimal.ROUND_HALF_UP);
        return tdee;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Products> getDietxMeal(int dietId) {
        return productsRepository.getDietxMeal(dietId);
    }

    @Override
    public List<Products> getIdProducts() {
        return productsRepository.getIdProducts();
    }
}
