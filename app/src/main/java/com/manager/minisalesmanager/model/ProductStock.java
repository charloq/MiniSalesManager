package com.manager.minisalesmanager.model;

/**
 * Created by charloq on 2/06/16.
 */
public class ProductStock extends Entity{
    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
