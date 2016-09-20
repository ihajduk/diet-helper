package com.diethelper.repository;

import com.diethelper.model.Diets;
import com.diethelper.model.MealType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by iwha on 9/7/2016.
 */
@Repository
public class DietRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Integer> findDietsWithDinnersHavingMoreFatThan100() {
        List<Integer> diets = entityManager
                .createQuery("SELECT d.idDiet FROM Products p, Meals m, Diets d " +
                        "JOIN d.meals dxm JOIN m.products mxp " +
                        "WHERE dxm.idMeal=m.idMeal AND mxp.idProduct=p.idProduct AND m.type = :type " +
                        "GROUP BY d.idDiet " +
                        "HAVING SUM(p.fat)>100").setParameter("type", MealType.DINNER).getResultList();
        return diets;
    }

    public void save(Diets diet){
        entityManager.persist(diet);
    }
}
