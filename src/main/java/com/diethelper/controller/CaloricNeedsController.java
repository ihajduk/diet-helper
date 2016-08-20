package com.diethelper.controller;

import com.diethelper.model.CaloricNeedsForm;
import com.diethelper.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by iwoha on 7/24/2016.
 */
@Controller
public class CaloricNeedsController {

    private ProductsService productsService;

    @Autowired
    CaloricNeedsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayCaloricPage(@ModelAttribute("caloricNeedsForm") CaloricNeedsForm caloricNeedsForm) {
        return "indexform";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postCaloricPage(@ModelAttribute("caloricNeedsForm") CaloricNeedsForm caloricNeedsForm,
                                  HttpServletRequest request) {
        BigDecimal calories = productsService.countCaloricNeeds(caloricNeedsForm);
        request.getSession().setAttribute("calories", calories);
        return "redirect:/diet";
    }
}
