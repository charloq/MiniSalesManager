package com.manager.minisalesmanager.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.manager.minisalesmanager.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by charloq on 16/05/16.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MANAGER";
    private static final int DATABASE_VERSION = 1;

    public String getSQLCreate() {
        StringBuilder sqlCreate = new StringBuilder();
        sqlCreate.append("CREATE TABLE PRODUCTS (ID INTEGER NOT NULL, DESCRIPTION TEXT, PRICE REAL, BARCODE TEXT, PRIMARY KEY(ID));");
        return sqlCreate.toString();
    }


    public DataBaseHandler(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(getSQLCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTS");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(getSQLCreate());
    }

    public long addProduct(String description, BigDecimal price, String barCode) {
        ProductDAO dao = ProductDAO.getInstance(this.getWritableDatabase());
        return dao.insertProduct(description, price, barCode);
    }

    public ArrayList<Product> getProducts() {
        ProductDAO dao = ProductDAO.getInstance(this.getWritableDatabase());
        return dao.getProducts();
    }
}
