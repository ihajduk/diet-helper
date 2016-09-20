package com.diethelper.repository;

import com.diethelper.model.MealType;
import com.diethelper.model.Meals;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by iwoha on 6/20/2016.
 */
@Repository
public class MealsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * NamedQuery finder
     */
    public List<Meals> getMealsByType(MealType type) {
        @SuppressWarnings("unchecked")
        List<Meals> ms = (List<Meals>) entityManager
                .createNamedQuery("Meals.findAllByType")
                .setParameter("type", type).getResultList();
        return ms;
    }

    public void save(Meals meal){
        entityManager.persist(meal);
    }
}
