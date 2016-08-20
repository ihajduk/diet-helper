package com.diethelper;

import com.diethelper.model.Products;
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

    @Test
    @Transactional
    public void testGet() throws Exception {
        List<Products> prods = productsRepository.getProductsByMoreProtein(BigDecimal.valueOf(3L));
        assertEquals(6, prods.size());
    }

    @Test
    @Transactional
    public void testIdProducts() throws Exception {
        List<Products> prods = productsRepository.getIdProducts();
    }

    @Test
    @Transactional
    public void testGetMealxProd() throws Exception {
        List<Products> prods = productsRepository.getMealxProd();
        assertEquals(7, prods.size());
    }

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
}