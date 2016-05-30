package com.manager.minisalesmanager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.manager.minisalesmanager.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by charloq on 16/05/16.
 */
public class ProductDAO {
    private SQLiteDatabase db;
    private static ProductDAO dao;
    private static final String PRODUCT_TABLE = "PRODUCTS";
    private static final String PRODUCTID = "ID";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PRICE = "PRICE";
    private static final String BARCODE = "BARCODE";
    private static final String[] COLUMNS = {PRODUCTID, DESCRIPTION, PRICE, BARCODE};


    public ProductDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public static ProductDAO getInstance(SQLiteDatabase db) {
        if(dao == null) {
            dao = new ProductDAO(db);
        }
        return dao;
    }

    public long insertProduct(String description, BigDecimal price, String barCode) {
        long result = 0;
        ContentValues row = new ContentValues();
        row.put(DESCRIPTION, description);
        row.put(PRICE, price.toPlainString());
        row.put(BARCODE, barCode);
        result = db.insert(PRODUCT_TABLE, null, row);
        return result;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product product;
        Cursor cursor = db.query(PRODUCT_TABLE, COLUMNS, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    product = new Product();
                    product.setId(cursor.getLong(0));
                    product.setDescription(cursor.getString(1));
                    product.setPrice(new BigDecimal(cursor.getLong(2)));
                    product.setBarCode(cursor.getString(3));
                    productList.add(product);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return productList;
    }
}
