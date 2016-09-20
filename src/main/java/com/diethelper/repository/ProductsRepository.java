package com.diethelper.repository;

import com.diethelper.dto.NutritionStatsDTO;
import com.diethelper.model.Products;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static org.springframework.orm.hibernate3.SessionFactoryUtils.getSession;

/**
 * Created by iwoha on 6/19/2016.
 */
@Repository
public class ProductsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * NamedQuery finder
     */
    public List<Products> getProductsByMoreProtein(BigDecimal protein) {
        @SuppressWarnings("unchecked")
        List<Products> prods = (List<Products>) entityManager
                .createNamedQuery("Products.findAllWithMoreProtein")
                .setParameter("protein", protein).getResultList();
        return prods;
    }

    public List<Products> getIdProducts() {
        List<Products> prods = (List<Products>) entityManager
                .createQuery("SELECT idProduct FROM Products").getResultList();
        return prods;
    }

    public List<Products> getMealxProd() {
        List<Products> prods = (List<Products>) entityManager
                .createQuery("SELECT p FROM Products p, Meals m JOIN m.products mxp WHERE mxp.idProduct=p.idProduct").getResultList();
        return prods;
    }

    public List<Products> getDietxMeal(int dietId) {
        List<Products> prods = (List<Products>) entityManager
                .createQuery("SELECT p FROM Products p, Meals m, Diets d " +
                        "JOIN d.meals dxm JOIN m.products mxp " +
                        "WHERE d.idDiet= :dietId AND dxm.idMeal=m.idMeal AND mxp.idProduct=p.idProduct").setParameter("dietId", dietId).getResultList();
        return prods;
    }

    public List<Products> find3ProductsMostPopular() {
        List<Products> prods = (List<Products>) entityManager
                .createQuery("SELECT p FROM Products p, Meals m, Diets d " +
                        "JOIN d.meals dxm JOIN m.products mxp " +
                        "WHERE dxm.idMeal=m.idMeal AND mxp.idProduct=p.idProduct " +
                        "GROUP BY p.productName " +
                        "ORDER BY SUM(p.idProduct) " +
                        "DESC").setMaxResults(3).getResultList();
        // TODO: description: wholesale purchase
        return prods;
    }


        // TODO: sum, median?
    public List<NutritionStatsDTO> findAvgMidSumOfNutritientsForAllDiets() {
        return (List<NutritionStatsDTO>) entityManager.unwrap(Session.class)
                .createQuery("SELECT d.idDiet as idDiet, AVG(p.protein) as avgProtein, AVG(p.carbohydrate) as avgCarbohydrate, AVG(p.fat) as avgFat " +
                        "FROM Products p, Meals m, Diets d " +
                        "JOIN d.meals dxm JOIN m.products mxp " +
                        "WHERE dxm.idMeal=m.idMeal AND mxp.idProduct=p.idProduct " +
                        "GROUP BY d.idDiet")
                .setResultTransformer(Transformers.aliasToBean(NutritionStatsDTO.class)).list();
    }


    public void save(Products product) {
        entityManager.persist(product);
    }
}
