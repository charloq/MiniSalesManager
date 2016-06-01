package com.manager.minisalesmanager.model;

/**
 * Created by charloq on 13/05/16.
 */
public class Sale extends Operation{
    public PayMode getPayMode() {
        return payMode;
    }

    public void setPayMode(PayMode payMode) {
        this.payMode = payMode;
    }

    private PayMode payMode;


}
