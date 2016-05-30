package com.manager.minisalesmanager.model;

import java.math.BigDecimal;

/**
 * Created by charloq on 13/05/16.
 */
public class Product extends Entity{
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
