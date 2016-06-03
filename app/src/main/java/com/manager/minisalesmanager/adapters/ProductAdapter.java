package com.manager.minisalesmanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.activity.ProductDetailActivity;
import com.manager.minisalesmanager.activity.ProductsActivity;
import com.manager.minisalesmanager.commons.Utils;
import com.manager.minisalesmanager.model.Product;

import java.util.ArrayList;

/**
 * Created by charloq on 25/05/16.
 */
public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Holder holder = new Holder();

        final View layoutProduct = inflater.inflate(R.layout.content_products, parent, false);
        TextView txtBarCode = (TextView) layoutProduct.findViewById(R.id.barcode);
        TextView txtDescription = (TextView) layoutProduct.findViewById(R.id.description);
        TextView txtPrice = (TextView) layoutProduct.findViewById(R.id.price);
        Product actualProduct = products.get(position);
        txtBarCode.setText(actualProduct.getBarCode());
        txtDescription.setText(actualProduct.getDescription());
        txtPrice.setText(Utils.currencyFormat(actualProduct.getPrice()));
        return layoutProduct;
    }
}
