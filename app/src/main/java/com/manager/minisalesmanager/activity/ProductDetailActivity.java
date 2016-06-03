package com.manager.minisalesmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Product product = getIntent().getParcelableExtra("product");
        TextView txtBarCode = (TextView) findViewById(R.id.barcode);
        TextView txtDescription = (TextView) findViewById(R.id.description);
        TextView txtPrice = (TextView) findViewById(R.id.price);

        txtBarCode.setText(product.getBarCode());
        txtDescription.setText(product.getDescription());
        txtPrice.setText(product.getPrice().toPlainString());

    }
}
