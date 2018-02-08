package com.hellohasan.spinnerpractice;

public class Food {
    private String name;
    private int price;
    private String image;
    private FoodType foodType;
    private boolean isFavorite;

    public Food(String name, int price, String image, FoodType foodType, boolean isFavorite) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodType = foodType;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
