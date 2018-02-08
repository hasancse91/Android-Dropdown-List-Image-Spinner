package com.hellohasan.spinnerpractice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView foodNameTextView;
    TextView foodPriceTextView;
    ImageView foodImageView;
    ImageView favoriteIcon;

    public CustomViewHolder(View itemView) {
        super(itemView);
        foodNameTextView = itemView.findViewById(R.id.nameTextView);
        foodPriceTextView = itemView.findViewById(R.id.priceTextView);
        foodImageView = itemView.findViewById(R.id.imageView);
        favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
    }
}
