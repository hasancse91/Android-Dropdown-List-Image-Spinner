package com.hellohasan.spinnerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private SpinnerAdapter spinnerAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<FoodCategoryModel> foodCategoryModelList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinnerAdapter = new SpinnerAdapter(this, foodCategoryModelList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, foodList, FoodType.BREAKFAST);

        setSpinner();

        setRecyclerView();
    }

    private void setSpinner() {
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.breakfast, getString(R.string.breakfast), FoodType.BREAKFAST));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.lunch, getString(R.string.lunch), FoodType.LUNCH));
        foodCategoryModelList.add(new FoodCategoryModel(R.drawable.dinner, getString(R.string.dinner), FoodType.DINNER));

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                setFoodFilter(foodCategoryModelList.get(i).getFoodType());
                recyclerViewAdapter.setFoodTypeForFiltering(foodCategoryModelList.get(i).getFoodType());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setRecyclerView() {
        foodList.add(new Food("Naan and Beef", 270, "https://i.imgur.com/wbPsQkF.jpg", FoodType.BREAKFAST, false));
        foodList.add(new Food("Bhuna Khichuri", 709, "https://i.imgur.com/t7RFhqo.jpg", FoodType.DINNER, false));
        foodList.add(new Food("Bread and Butter", 870, "https://i.imgur.com/nHVHVyh.jpg", FoodType.BREAKFAST, false));
        foodList.add(new Food("Khachchi Biriani", 902, "https://i.imgur.com/urUkLwP.jpg", FoodType.LUNCH, false));
        foodList.add(new Food("Vorta vaat", 605, "https://i.imgur.com/XtBpoch.jpg", FoodType.DINNER, false));
        foodList.add(new Food("Mejbani Khana", 680, "https://i.imgur.com/HmnJ6Zo.jpg", FoodType.LUNCH, false));
        foodList.add(new Food("Parata and Nihari", 550, "https://i.imgur.com/Axh20v0.jpg", FoodType.BREAKFAST, false));
        foodList.add(new Food("Polau and Leg roast", 320, "https://i.imgur.com/Oqyx0Ww.jpg", FoodType.DINNER, false));
        foodList.add(new Food("Bread and Egg", 120, "https://i.imgur.com/noH9648.jpg", FoodType.BREAKFAST, false));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
