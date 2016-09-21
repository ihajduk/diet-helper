package com.diethelper.dto;

import java.math.BigDecimal;

/**
 * Created by iwha on 9/20/2016.
 */

public class NutritionStatsDTO {
    private Integer idDiet;
    private Double avgProtein;
    private Double avgCarbohydrate;
    private Double avgFat;
    private BigDecimal sumProtein;
    private BigDecimal sumCarbohydrate;
    private BigDecimal sumFat;

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

    public void setSumProtein(BigDecimal sumProtein) {
        this.sumProtein = sumProtein;
    }

    public void setSumCarbohydrate(BigDecimal sumCarbohydrate) {
        this.sumCarbohydrate = sumCarbohydrate;
    }

    public void setSumFat(BigDecimal sumFat) {
        this.sumFat = sumFat;
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

    public BigDecimal getSumProtein() {
        return sumProtein;
    }

    public BigDecimal getSumCarbohydrate() {
        return sumCarbohydrate;
    }

    public BigDecimal getSumFat() {
        return sumFat;
    }

    @Override
    public String toString() {
        return "diet ID: " + idDiet + ", averages: Protein: " + avgProtein +
                    "g  Carbohydrate: " + avgCarbohydrate + "g Fat: "+ avgFat +
                    "g, Sums: Protein " + sumProtein + "g Carbohydrate: " +
                sumCarbohydrate + "g Fat: "+ sumFat +"g";
    }
}
