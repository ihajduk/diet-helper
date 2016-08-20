package com.diethelper.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by iwoha on 6/20/2016.
 */
@NamedQuery(name = "Meals.findAllByType", query = "select m from Meals m where m.type = :type")
@Table(name = "MEALS")
@Entity
public class Meals {
    @Id
    @GeneratedValue
    @Column(name = "ID_MEAL")
    private int idMeal;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private MealType type;

    @OneToMany
    @JoinTable(
            name = "MEALXPROD",
            joinColumns = @JoinColumn(name = "ID_MEAL"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD")
    )
    private Collection<Products> products;

    public int getIdMeal() {
        return idMeal;
    }

    public MealType getType() {
        return type;
    }

    public Collection<Products> getProducts() {
        return products;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }
}
