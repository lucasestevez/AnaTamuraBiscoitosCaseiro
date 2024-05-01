package com.br.anatamurabiscoitoscaseiros.model;

public class Food {

    private final int imgFood;
    private final String foodName;
    private final String foodDescription;
    private final String foodPrice;

    public Food(int imgFood, String foodName, String foodDescription, String foodPrice) {
        this.imgFood = imgFood;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodPrice = foodPrice;
    }

    public int getImgFood() {
        return imgFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

}
