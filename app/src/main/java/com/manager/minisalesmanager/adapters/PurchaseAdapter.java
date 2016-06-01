package com.manager.minisalesmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.manager.minisalesmanager.R;
import com.manager.minisalesmanager.model.Product;
import com.manager.minisalesmanager.model.Purchase;

import java.util.ArrayList;

/**
 * Created by charloq on 30/05/16.
 */
public class PurchaseAdapter extends ArrayAdapter<Purchase> {

    private final Context context;
    private final ArrayList<Purchase> purchases;
    public PurchaseAdapter(Context context, ArrayList<Purchase> purchases) {
        super(context, -1, purchases);
        this.context = context;
        this.purchases = purchases;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutPurchases = inflater.inflate(R.layout.content_purchases, parent, false);
        TextView txtDescription = (TextView)layoutPurchases.findViewById(R.id.description);
        TextView txtAmount = (TextView)layoutPurchases.findViewById(R.id.amount);
        Purchase actualPurchase = purchases.get(position);
        txtDescription.setText(actualPurchase.getDescription());
        txtAmount.setText("$" + actualPurchase.getAmount().toPlainString());

        return layoutPurchases;
    }
}
