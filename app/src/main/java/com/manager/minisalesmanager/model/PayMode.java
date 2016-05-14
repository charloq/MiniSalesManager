package com.manager.minisalesmanager.model;

/**
 * Created by charloq on 13/05/16.
 */
public enum PayMode {
    CASH("1", "Contado"), TWO("2", "Dos pagos"), THREE("3", "Tres pagos");
    private String id;
    private String payMode;

    private PayMode(String id, String payMode){
        this.id = id;
        this.payMode = payMode;
    }

    @Override
    public String toString() {
        return payMode;
    }
}
