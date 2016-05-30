package com.manager.minisalesmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.dao.DataBaseHandler;

import java.math.BigDecimal;

public class AddProductActivity extends AppCompatActivity {
    String scanData = "";
    private EditText descriptionText;
    private EditText priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Intent intentFromProduct = getIntent();
        scanData = intentFromProduct.getStringExtra("scanData");
        descriptionText = (EditText) findViewById(R.id.description);
        priceText = (EditText) findViewById(R.id.price);

    }
/*
    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                textView.setVisibility(View.GONE);
            } else{
                textView.setText("You have entered : " + passwordEditText.getText());
            }
        }
    };*/

    public void addProduct(View view) {
        Intent intentProductsData = new Intent(this, ProductsActivity.class);
        String description = descriptionText.getText().toString();
        BigDecimal price = new BigDecimal(priceText.getText().toString());
        DataBaseHandler db = new DataBaseHandler(this);
        db.addProduct(description, price, scanData);
        Log.d("Insert: ", "Product with bar code " + scanData);
        this.startActivity(intentProductsData);
    }
}
