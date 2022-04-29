package com.example.navigationdrawer;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {

    private int ID;
    private String Name;
    private String Desc;
    private double price;
    private double total_price;
    private int Img;
    private int Amount = 0;


    public Dish(int ID, String name, String desc, double price, int img) {
        this.ID = ID;
        Name = name;
        Desc = desc;
        this.price = price;
        this.total_price = price;
        Img = img;
    }

    protected Dish(Parcel in) {
        ID = in.readInt();
        Name = in.readString();
        Desc = in.readString();
        price = in.readDouble();
        total_price = in.readDouble();
        Img = in.readInt();
        Amount = in.readInt();

    }

    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Name);
        dest.writeString(Desc);
        dest.writeDouble(price);
        dest.writeDouble(total_price);
        dest.writeInt(Img);
        dest.writeInt(Amount);
    }
}
