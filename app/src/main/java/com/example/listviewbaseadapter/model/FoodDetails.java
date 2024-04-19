package com.example.listviewbaseadapter.model;


public class FoodDetails {
    private String foodName;
    private String foodDesc;
    private Integer foodImageId;

    public FoodDetails(){}

    public FoodDetails(String foodName, String foodDesc, Integer foodImageId) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodImageId = foodImageId;
    }

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
}
