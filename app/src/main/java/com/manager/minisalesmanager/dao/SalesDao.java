package com.manager.minisalesmanager.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.manager.minisalesmanager.model.PayMode;
import com.manager.minisalesmanager.model.Product;
import com.manager.minisalesmanager.model.Sale;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by charloq on 30/05/16.
 */
public class SalesDao {

    private SQLiteDatabase db;
    private static SalesDao dao;
    private static final String SALES_TABLE = "SALES";
    private static final String SALESID = "ID";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PAYMODE = "PAYMODE";
    private static final String AMOUNT = "AMOUNT";
    private static final String[] COLUMNS = {SALESID, DESCRIPTION, AMOUNT, PAYMODE};

    public SalesDao(SQLiteDatabase db) {
        this.db = db;
    }

    public static SalesDao getInstance(SQLiteDatabase db) {
        if(dao == null) {
            dao = new SalesDao(db);
        }
        return dao;
    }

    private long insertSales(String description, BigDecimal amount, String paymode, List<Product> productList) {
        long result = 0;
        ContentValues row = new ContentValues();
        //TODO: Hacer el insert
        return result;
    }
}
