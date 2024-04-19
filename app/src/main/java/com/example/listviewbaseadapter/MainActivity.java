package com.example.listviewbaseadapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewbaseadapter.adapter.FoodAdapter;
import com.example.listviewbaseadapter.model.FoodDetails;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private int[] imageIds = new int[] {R.drawable.food2, R.drawable.food2, R.drawable.food2};
    private String[] foodNames = new String[] {"Mi Xian", "Ji Gong Bao", "Huo Guo"};
    private String[] foodDesc = new String[] {"Mi XianMi XianJi Gong BaoMi Xian", "Ji Gong BaoMi XianJi Gong BaoMi Xian", "Huo GuoMi Xian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listview);

        //数据列表 List Data
        List<FoodDetails> foodDetailsList = new ArrayList<>();
        for(int i=0; i<imageIds.length; i++){
            FoodDetails foodDetails = new FoodDetails();
            foodDetails.setFoodName(foodNames[i]);
            foodDetails.setFoodDesc(foodDesc[i]);
            foodDetails.setFoodImageId(imageIds[i]);

            foodDetailsList.add(foodDetails);
        }

        //创建适配器 Create an Adapter
        FoodAdapter adapter = new FoodAdapter(this, foodDetailsList);

        //绑定适配器 Binding Adapter
        listView.setAdapter(adapter);
    }
}