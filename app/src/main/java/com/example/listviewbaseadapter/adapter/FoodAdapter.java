package com.example.listviewbaseadapter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewbaseadapter.R;
import com.example.listviewbaseadapter.model.FoodDetails;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context = null;
    List<FoodDetails> foodDetails;

    public FoodAdapter(Context context, List<FoodDetails> foodDetails) {
        this.context = context;
        this.foodDetails = foodDetails;
    }

    @Override
    public int getCount() {
        return foodDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return foodDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.foods_item, null, true);
            viewHolder.textName = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.textDesc = (TextView) convertView.findViewById(R.id.textViewDesc);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String foodName = foodDetails.get(position).getFoodName();
        String foodDesc = foodDetails.get(position).getFoodDesc();
        int foodImageId = foodDetails.get(position).getFoodImageId();

        Log.d("FoodAdapter", "Food Name: " + foodName); // Log Food Name
        Log.d("FoodAdapter", "Food Desc: " + foodDesc); // Log Food Desc
        Log.d("FoodAdapter", "Food Image Id: " + foodImageId); // Log Food Image Id

        viewHolder.textName.setText(foodName);
        viewHolder.textDesc.setText(foodDesc);
        viewHolder.imageView.setImageResource(foodImageId);

        return convertView;

    }

    class ViewHolder {
        private TextView textName;
        private TextView textDesc;
        private ImageView imageView;
    }
}
