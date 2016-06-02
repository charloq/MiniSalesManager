package com.manager.minisalesmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.manager.minisalesmanager.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView txtBarCode = (TextView) findViewById(R.id.barcode);
        TextView txtdescription = (TextView) findViewById(R.id.description);
        TextView txtPrice = (TextView) findViewById(R.id.price);


    }
}
