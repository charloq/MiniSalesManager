package com.manager.minisalesmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.adapters.ProductAdapter;
import com.manager.minisalesmanager.dao.DataBaseHandler;
import com.manager.minisalesmanager.model.Product;

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView productList = (ListView) findViewById(R.id.listProduct);
        DataBaseHandler db = new DataBaseHandler(this);
        ProductAdapter adapter = new ProductAdapter(this, db.getProducts());
        //ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, db.getProducts());
        productList.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.scanner_button);
        fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.scanner_button) { // para saber si esta presionado
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Intent intentProductData = new Intent(this, AddProductActivity.class);
        String scanData = "";
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(scanningResult == null) {
            //TODO: agregar una validacion
        } else {
            scanData = scanningResult.getContents();
            intentProductData.putExtra("scanData", scanData);
            this.startActivity(intentProductData);
        }
    }
}
