package com.diethelper.configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by iwha on 9/8/2016.
 */
public class PopulateDatabaseClass {
    public static void populateDBWithRandomData() throws IOException {
        Random random = new Random();
        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("data-fast-track.sql"), "utf-8"));

        // PRODUCTS
        for (int i = 1; i <= 500; i++) {
            writer.write("INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES "
                    + "(" + i                              // id
                    + ", 'product" + i                     // product_name
                    + "', " + random.nextInt(50)           // weight_base
                    + ", " + random.nextInt(50)            // weight_add
                    + ", " + random.nextInt(50)            // protein
                    + ", " + random.nextInt(50)            // carbohydrate
                    + ", " + random.nextInt(50)            // fat
                    + "); \n");
        }

        // MEALS:breakfasts, dinners, suppers
        List<String> mealType = Arrays.asList("BREAKFAST", "DINNER", "SUPPER");
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < 3; j++) {
                int id = i + (100 * j);
                writer.write("INSERT INTO `meals` (`ID_MEAL`, `type`) VALUES "
                        + "(" + id             // 1..100 BREAKFAST , 101..200 DINNER, 201..300 SUPPER
                        + ", '" + mealType.get(j) + "'"
                        + "); \n");
            }
        }

        // MEALXPROD
        for (int i = 1; i <= 300; i++) {
            for (int j = 0; j < random.nextInt(2) + 4; j++) {
                writer.write("INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES "
                        + "(" + i
                        + ", " + random.nextInt(500)+1
                        + "); \n");
            }
        }

        //DIETS
        for (int i = 1; i <= 1000; i++) {
            writer.write("INSERT INTO `diets` (`ID_DIET`, `opis`) VALUES "
                    + "(" + i
                    + ", 'diet" + i + "'"
                    + "); \n");
        }

        //DIETXMEAL
        for (int i = 1; i <= 1000; i++) {
            List<Integer> mealsInDiet = new ArrayList<>();
            mealsInDiet.add(random.nextInt(100) + 1);                                                       // BREAKFAST: 1
            for (int j = 0; j < random.nextInt(3) + 1; j++) mealsInDiet.add(random.nextInt(100) + 101);     // DINNER: 1-3 dinners
            mealsInDiet.add(random.nextInt(100) + 201);                                                     // SUPPER: 1
            for (int k : mealsInDiet) {
                writer.write("INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES "
                        + "(" + i
                        + "," + k
                        + "); \n");
            }
        }

        writer.close();
    }
}
