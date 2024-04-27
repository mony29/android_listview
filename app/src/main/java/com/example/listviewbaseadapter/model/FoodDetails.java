package com.example.listviewbaseadapter.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class FoodDetails implements Parcelable {
    private String foodName;
    private String foodDesc;
    private Integer foodImageId;

    public FoodDetails(){}

    public FoodDetails(String foodName, String foodDesc, Integer foodImageId) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodImageId = foodImageId;
    }

    protected FoodDetails(Parcel in) {
        foodName = in.readString();
        foodDesc = in.readString();
        if (in.readByte() == 0) {
            foodImageId = null;
        } else {
            foodImageId = in.readInt();
        }
    }

    public static final Creator<FoodDetails> CREATOR = new Creator<FoodDetails>() {
        @Override
        public FoodDetails createFromParcel(Parcel in) {
            return new FoodDetails(in);
        }

        @Override
        public FoodDetails[] newArray(int size) {
            return new FoodDetails[size];
        }
    };

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public Integer getFoodImageId() {
        return foodImageId;
    }

    public void setFoodImageId(Integer foodImageId) {
        this.foodImageId = foodImageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(foodName);
        dest.writeString(foodDesc);
        if (foodImageId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(foodImageId);
        }
    }
}
