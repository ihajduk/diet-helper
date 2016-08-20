package com.diethelper.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by iwoha on 6/19/2016.
 */
@NamedQuery(name = "Products.findAllWithMoreProtein", query = "select p.productName from Products p where p.protein > :protein")
@Table(name = "PRODUCTS")
@Entity
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUCT")
    private int idProduct;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "WEIGHT_BASE")
    private int weightBase;

    @Column(name = "WEIGHT_ADD")
    private int weightAdd;

    @Column(name = "PROTEIN")
    private BigDecimal protein;

    @Column(name = "CARBOHYDRATE")
    private BigDecimal carbohydrate;

    @Column(name = "FAT")
    private BigDecimal fat;

    public int getIdProduct() {
        return idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public int getWeightBase() {
        return weightBase;
    }

    public int getWeightAdd() {
        return weightAdd;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public BigDecimal getFat() {
        return fat;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductName(String prodName) {
        this.productName = prodName;
    }

    public void setWeightBase(int weightBase) {
        this.weightBase = weightBase;
    }

    public void setWeightAdd(int weightAdd) {
        this.weightAdd = weightAdd;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "[" + idProduct + "," + productName + "," + weightBase + "," + weightAdd + "," + protein + "," +
                carbohydrate + "," + fat + "]";
    }
}
