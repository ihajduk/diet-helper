package com.diethelper;

import com.diethelper.model.MealType;
import com.diethelper.model.Meals;
import com.diethelper.repository.MealsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by iwoha on 6/20/2016.
 */
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:/META-INF/business-config.xml"})
@ActiveProfiles("jpa")
@RunWith(SpringJUnit4ClassRunner.class)
public class MealsPersistenceTest {
    @Autowired
    private MealsRepository mealsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testGet() throws Exception {
        List<Meals> ms = mealsRepository.getMealsByType(MealType.DINNER);
        assertEquals(1, ms.size());
    }
}