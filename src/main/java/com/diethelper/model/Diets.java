package com.diethelper.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by iwoha on 6/20/2016.
 */
@Entity
@Table(name = "DIETS")
public class Diets {
    @Id
    @GeneratedValue
    @Column(name = "ID_DIET")
    private int idDiet;

    @Column(name="OPIS")
    private String opis;

    @OneToMany
    @JoinTable(
            name = "DIETXMEAL",
            joinColumns = @JoinColumn(name = "ID_DIET"),
            inverseJoinColumns = @JoinColumn(name = "ID_MEAL")
    )
    private Collection<Meals> meals;

    public int getIdDiet() {
        return idDiet;
    }

    public String getOpis() {
        return opis;
    }

    public Collection<Meals> getMeals() {
        return meals;
    }

    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setMeals(Collection<Meals> meals) {
        this.meals = meals;
    }
}
