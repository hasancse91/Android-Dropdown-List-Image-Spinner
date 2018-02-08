package com.hellohasan.spinnerpractice;

public class FoodCategoryModel {
    private int image;
    private String title;
    private FoodType foodType;

    public FoodCategoryModel(int image, String title, FoodType foodType) {
        this.image = image;
        this.title = title;
        this.foodType = foodType;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}
