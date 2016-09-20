package com.diethelper.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

/**
 * Created by iwha on 9/20/2016.
 */
@SqlResultSetMapping(
        name = "NutritionStatsDTOMapping",
        classes = @ConstructorResult(
                targetClass = NutritionStatsDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "avgProtein", type = Integer.class),
                        @ColumnResult(name = "avgCarbohydrate", type = Integer.class),
                        @ColumnResult(name = "avgFat", type = Integer.class)
                }
        ))
public class NutritionStatsDTO {
    private int idDiet;
    private int avgProtein;
    private int avgCarbohydrate;
    private int avgFat;

    public int getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }

    public int getAvgProtein() {
        return avgProtein;
    }

    public void setAvgProtein(int avgProtein) {
        this.avgProtein = avgProtein;
    }

    public int getAvgCarbohydrate() {
        return avgCarbohydrate;
    }

    public void setAvgCarbohydrate(int avgCarbohydrate) {
        this.avgCarbohydrate = avgCarbohydrate;
    }

    public int getAvgFat() {
        return avgFat;
    }

    public void setAvgFat(int avgFat) {
        this.avgFat = avgFat;
    }
}
