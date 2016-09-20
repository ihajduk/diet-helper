package com.diethelper;

import com.diethelper.dto.NutritionStatsDTO;
import com.diethelper.model.Diets;
import com.diethelper.model.Products;
import com.diethelper.repository.DietRepository;
import com.diethelper.repository.ProductsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by iwoha on 6/19/2016.
 */

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:/META-INF/business-config.xml"})
@ActiveProfiles("jpa")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductsPersistenceTest {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private DietRepository dietRepository;

    @Test
    @Transactional
    public void testGetDietNumberOne() throws Exception {
        int dietId = 1;
        List<Products> prods = productsRepository.getDietxMeal(dietId);
        for (Iterator<Products> i = prods.iterator(); i.hasNext(); ) {
            Products item = i.next();
            System.out.println(item.toString());
        }
        assertEquals(13, prods.size());
    }

    @Test
    @Transactional
    public void findDietsWithDinnersHavingMoreFatThan100(){
        List<Integer> diets = dietRepository.findDietsWithDinnersHavingMoreFatThan100();;
        for (Iterator<Integer> i = diets.iterator(); i.hasNext(); ) {
            Integer item = i.next();
            System.out.println("Diet id: " + item);
        }
    }

    @Test
    @Transactional
    public void find3ProductsMostPopular(){
        List<Products> prods = productsRepository.find3ProductsMostPopular();
        for (Iterator<Products> i = prods.iterator(); i.hasNext(); ) {
            Products item = i.next();
            System.out.println(item.toString());
        }
    }

    // TODO: not working yet
    @Test
    @Transactional
    public void findAvgMidSumOfNutritientsForAllDiets(){
        List<NutritionStatsDTO> list = productsRepository.findAvgMidSumOfNutritientsForAllDiets();
        list.forEach(System.out::println);
//        for (Iterator<NutritionStatsDTO> i = list.iterator(); i.hasNext();) {
//            NutritionStatsDTO item = i.next();
//            System.out.println("diet: " + item.getIdDiet() + " averages: Protein: " + item.getAvgProtein() +
//                    "g  Carbo: " + item.getAvgCarbohydrate() + "g Fat "+ item.getAvgFat());
//        }
    }


}