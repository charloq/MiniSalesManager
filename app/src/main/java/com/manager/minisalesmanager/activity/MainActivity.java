package com.manager.minisalesmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.manager.minisalesmanager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToProducts(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        this.startActivity(intent);
    }

    public void goToSales(View view) {
        Intent intent = new Intent(this, SalesActivity.class);
        this.startActivity(intent);
    }

    public void goToPurchases(View view) {
        Intent intent = new Intent(this, PurchasesActivity.class);
        this.startActivity(intent);
    }

}
