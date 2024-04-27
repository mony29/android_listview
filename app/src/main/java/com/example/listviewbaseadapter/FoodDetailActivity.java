package com.example.listviewbaseadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewbaseadapter.model.FoodDetails;

public class FoodDetailActivity extends AppCompatActivity {

    private TextView textViewDesc, textViewName;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewName = findViewById(R.id.textViewName);
        textViewDesc = findViewById(R.id.textViewDesc);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        if (intent.hasExtra("foodDetails")) {
            FoodDetails foodDetails = intent.getParcelableExtra("foodDetails");
            textViewName.setText(foodDetails.getFoodName());
            textViewDesc.setText(foodDetails.getFoodDesc());
            imageView.setImageResource(foodDetails.getFoodImageId());
        }else {

        }
    }
}