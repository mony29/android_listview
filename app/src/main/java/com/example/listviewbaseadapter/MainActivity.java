package com.example.listviewbaseadapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
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
    private int[] imageIds = new int[]{R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food2};
    private String[] foodNames = new String[]{"火锅糕点等中西美食", "大理美食", "重庆鸡公煲", "大理美食"};
    private String[] foodDesc = new String[]{"重庆鸡公煲重庆鸡公煲重庆鸡公煲重庆鸡公煲",
            "火锅糕点等中西美食火锅糕点等中西美食火锅糕点等中西美食 火锅糕点等中西美食",
            "重庆鸡公煲重庆鸡公煲重庆鸡公煲重庆鸡公煲 火锅糕点等中西美食火锅糕点等中西美食火锅糕点等中西美食 火锅糕点等中西美食",
            "重庆鸡公煲重庆鸡公煲重庆鸡"};

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
        for (int i = 0; i < imageIds.length; i++) {
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取点击位置的FoodDetails对象
                FoodDetails foodDetails = foodDetailsList.get(position);

                // 创建一个 Intent 来启动 FoodDetailActivity
                Intent intent = new Intent(MainActivity.this, FoodDetailActivity.class);
                intent.putExtra("foodDetails", (Parcelable) foodDetails);
                startActivity(intent);
            }
        });
    }
}



// Using SimpleAdapter
//public class MainActivity extends AppCompatActivity {
//    ListView listView;
//    private int[] imageIds = new int[]{R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food2};
//    private String[] foodNames = new String[]{"火锅糕点等中西美食", "大理美食", "重庆鸡公煲", "大理美食"};
//    private String[] foodDesc = new String[]{"重庆鸡公煲重庆鸡公煲重庆鸡公煲重庆鸡公煲",
//            "火锅糕点等中西美食火锅糕点等中西美食火锅糕点等中西美食 火锅糕点等中西美食",
//            "重庆鸡公煲重庆鸡公煲重庆鸡公煲重庆鸡公煲 火锅糕点等中西美食火锅糕点等中西美食火锅糕点等中西美食 火锅糕点等中西美食",
//            "重庆鸡公煲重庆鸡公煲重庆鸡"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        listView = findViewById(R.id.listview);
//
//        // Prepare data for SimpleAdapter
//        List<Map<String, Object>> data = new ArrayList<>();
//        for (int i=0; i<imageIds.length; i++){
//            Map<String, Object> item = new HashMap<>();
//            item.put("image", imageIds[i]);
//            item.put("foodName", foodNames[i]);
//            item.put("foodDesc", foodDesc[i]);
//            data.add(item);
//        }
//
//        // Define layout for each item in the list
//        String[] from = {"image", "foodName", "foodDesc"};
//        int[] to = {R.id.imageView, R.id.textViewName, R.id.textViewDesc};
//
//        // Create and Set SimpleAdapter
//        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.foods_item, from, to);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Get the click FoodDetail Object
//                Map<String, Object> item = data.get(position);
//                int imageId = (int) item.get("image");
//                String foodName = (String) item.get("foodName");
//                String foodDesc = (String) item.get("foodDesc");
//                FoodDetails foodDetails = new FoodDetails(foodName, foodDesc, imageId);
//
//                // Create an Intent to start FoodDetailActivity
//                Intent intent = new Intent(MainActivity.this, FoodDetailActivity.class);
//                intent.putExtra("foodDetails", (Parcelable) foodDetails);
//                startActivity(intent);
//            }
//        });
//    }
//}