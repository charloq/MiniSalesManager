package com.manager.minisalesmanager.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by charloq on 14/05/16.
 */
public class Operation {
    private String id;
    private List<Product> productList;
    private BigDecimal amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
