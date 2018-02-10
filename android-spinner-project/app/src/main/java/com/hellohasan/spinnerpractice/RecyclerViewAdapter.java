package com.hellohasan.spinnerpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Food> globalFoodList;
    private List<Food> localFoodList = new ArrayList<>();
    private Context context;
    private FoodType foodTypeForFiltering;

    public RecyclerViewAdapter(Context context, List<Food> globalFoodList, FoodType foodTypeForFiltering) {
        this.globalFoodList = globalFoodList;
        this.context = context;
        this.foodTypeForFiltering = foodTypeForFiltering;

        prepareLocalFoodList();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        final Food food = localFoodList.get(position);

        holder.foodNameTextView.setText(food.getName());
        holder.foodPriceTextView.setText(context.getString(R.string.price, food.getPrice()));

        Picasso.with(context)
                .load(food.getImage())
                .resize(200, 200)
                .into(holder.foodImageView);

        holder.favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(food.isFavorite()) {
                    holder.favoriteIcon.setImageResource(R.drawable.ic_favorite_border_24dp);
                    food.setFavorite(false);
                }
                else {
                    holder.favoriteIcon.setImageResource(R.drawable.ic_favorite_solid_24dp);
                    food.setFavorite(true);
                }
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodDetailsActivity.class);
                intent.putExtra("food", food);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return localFoodList.size();
    }

    private void prepareLocalFoodList() {
        localFoodList.clear();
        for(Food food: globalFoodList){
            if(food.getFoodType().equals(foodTypeForFiltering))
                localFoodList.add(food);
        }
    }

    public void setFoodTypeForFiltering(FoodType foodType){
        this.foodTypeForFiltering = foodType;
        prepareLocalFoodList();
        notifyDataSetChanged();
    }
}
