package com.hellohasan.spinnerpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FoodDetailsActivity extends AppCompatActivity {

    private ImageView favoriteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = findViewById(R.id.imageView);
        TextView foodNameTextView = findViewById(R.id.nameTextView);
        favoriteIcon = findViewById(R.id.favoriteIcon);
        TextView priceTextView = findViewById(R.id.priceTextView);

        final Food food = (Food) getIntent().getSerializableExtra("food");

        Picasso.with(this)
                .load(food.getImage())
                .resize(200, 200)
                .into(imageView);

        foodNameTextView.setText(food.getName());
        favoriteIcon.setImageResource(food.isFavorite() ? R.drawable.ic_favorite_solid_24dp : R.drawable.ic_favorite_border_24dp);
        priceTextView.setText(getResources().getString(R.string.price, food.getPrice()));

        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(food.isFavorite()) {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_border_24dp);
                    food.setFavorite(false);
                }
                else {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_solid_24dp);
                    food.setFavorite(true);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
