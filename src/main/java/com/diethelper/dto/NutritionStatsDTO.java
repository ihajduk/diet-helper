package com.diethelper.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.math.BigDecimal;

/**
 * Created by iwha on 9/20/2016.
 */

public class NutritionStatsDTO {
    private Integer idDiet;
    private Double avgProtein;
    private Double avgCarbohydrate;
    private Double avgFat;

    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }

    public void setAvgProtein(Double avgProtein) {
        this.avgProtein = avgProtein;
    }

    public void setAvgCarbohydrate(Double avgCarbohydrate) {
        this.avgCarbohydrate = avgCarbohydrate;
    }

    public void setAvgFat(Double avgFat) {
        this.avgFat = avgFat;
    }

    public int getIdDiet() {
        return idDiet;
    }

    public Double getAvgProtein() {
        return avgProtein;
    }

    public Double getAvgCarbohydrate() {
        return avgCarbohydrate;
    }

    public Double getAvgFat() {
        return avgFat;
    }

    @Override
    public String toString() {
        return "diet ID: " + idDiet + ", averages: Protein: " + getAvgProtein().intValue() +
                    "g  Carbohydrate: " + getAvgCarbohydrate().intValue() + "g Fat: "+ getAvgFat().intValue() +"g";
    }
}
