package com.hellohasan.spinnerpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<FoodCategoryModel> foodCategoryModelList;

    public SpinnerAdapter(Context context, List<FoodCategoryModel> foodCategoryModelList) {
        this.context = context;
        this.foodCategoryModelList = foodCategoryModelList;
    }

    @Override
    public int getCount() {
        return foodCategoryModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item_spinner, null);

        ImageView imageView = view.findViewById(R.id.spinnerImageView);
        TextView titleTextView = view.findViewById(R.id.title);

        FoodCategoryModel foodCategoryModel = foodCategoryModelList.get(i);

        imageView.setImageResource(foodCategoryModel.getImage());
        titleTextView.setText(foodCategoryModel.getTitle());

        return view;
    }
}
