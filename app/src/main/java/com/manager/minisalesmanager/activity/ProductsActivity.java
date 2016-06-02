package com.manager.minisalesmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.adapters.ProductAdapter;
import com.manager.minisalesmanager.dao.DataBaseHandler;
import com.manager.minisalesmanager.model.Product;

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener{
    private final String LOGTAG ="ProductsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView productList = (ListView) findViewById(R.id.list_product);
        DataBaseHandler db = new DataBaseHandler(this);
        ProductAdapter adapter = new ProductAdapter(this, db.getProducts());
        productList.setAdapter(adapter);
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), product.getDescription(), Toast.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.scanner_button);
        fab.setOnClickListener(this);
        Log.i(LOGTAG, "Show activity");
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.scanner_button) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Intent intentProductData = new Intent(this, AddProductActivity.class);
        String scanData;
        try {
            IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (scanningResult != null) {
                Log.i(LOGTAG, "Barcode scanning");
                scanData = scanningResult.getContents();
                intentProductData.putExtra("scanData", scanData);
                this.startActivity(intentProductData);
            }
        } catch(Exception e) {
            Log.e(LOGTAG, "Error barcode scanning", e);
        }
    }
}
