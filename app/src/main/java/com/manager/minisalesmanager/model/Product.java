package com.manager.minisalesmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * Created by charloq on 13/05/16.
 */
public class Product extends Entity implements Parcelable{
    private BigDecimal price;
    private String barCode;

    public Product(){

    }

    protected Product(Parcel in) {
        this.setId(in.readLong());
        this.setDescription(in.readString());
        price = (BigDecimal)in.readSerializable(); //new BigDecimal(in.readString());
        barCode = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getDescription());
        dest.writeSerializable(price);
        dest.writeString(barCode);
    }
}
