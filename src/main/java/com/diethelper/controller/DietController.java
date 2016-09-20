package com.diethelper.controller;

import com.diethelper.model.Products;
import com.diethelper.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by iwoha on 7/27/2016.
 */
@Controller
public class DietController {

    private FoodService foodService;

    @Autowired
    DietController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/diet", method = RequestMethod.GET)
    public String dietView(HttpServletRequest request) {
        List<Products> productsList = foodService.getDietxMeal(1);
        request.getSession().setAttribute("productsList", productsList);
        BigDecimal calories = (BigDecimal) request.getSession().getAttribute("calories");

        return "calories";
    }

}
