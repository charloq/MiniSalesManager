package com.manager.minisalesmanager.model;

import java.math.BigDecimal;

/**
 * Created by charloq on 13/05/16.
 */
public class Product {
    private String id;
    private String description;
    private BigDecimal price;
    private String barCode;

    public Product(){

    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
