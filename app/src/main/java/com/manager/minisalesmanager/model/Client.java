package com.manager.minisalesmanager.model;

/**
 * Created by charloq on 2/06/16.
 */
public class Client extends Entity {
    private String address;
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
