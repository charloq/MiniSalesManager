package com.manager.minisalesmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.dao.DataBaseHandler;

import java.math.BigDecimal;

public class AddProductActivity extends AppCompatActivity {
    String scanData = "";
    private EditText descriptionText;
    private EditText priceText;
    private final String LOGTAG = "AddProductActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Intent intentFromProduct = getIntent();
        scanData = intentFromProduct.getStringExtra("scanData");
        descriptionText = (EditText) findViewById(R.id.description);
        priceText = (EditText) findViewById(R.id.price);
        descriptionText.setText("");
        priceText.setText("");

    }

    public void addProduct(View view) {
        Intent intentProductsData = new Intent(this, ProductsActivity.class);
        long result;
        if (TextUtils.isEmpty(descriptionText.getText().toString()) || TextUtils.isEmpty(priceText.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.error_fields_required), Toast.LENGTH_LONG).show();
        } else {
            String description = descriptionText.getText().toString();
            BigDecimal price = new BigDecimal(priceText.getText().toString());
            DataBaseHandler db = new DataBaseHandler(this);
            result = db.addProduct(description, price, scanData);
            if (result == -1) {
                Toast.makeText(this, "No se ha podido agregar el producto requerido.", Toast.LENGTH_LONG).show();
                Log.e(LOGTAG, "Product with bar code " + scanData);
            }
            Log.d(LOGTAG, "Product with bar code " + scanData);
            this.startActivity(intentProductsData);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, ProductsActivity.class);
            this.startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
