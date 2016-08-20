package com.diethelper.repository;

import com.diethelper.model.Products;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

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
}
