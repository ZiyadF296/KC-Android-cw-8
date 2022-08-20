package com.example.android.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<Items> shopItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check to see if a bundle is passed in. If there is, that means there is an item to 
        // be added.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Items newItem = (Items) extras.getSerializable("item");
            shopItems.add(newItem);
        }

        final Items cheese = new Items("cheese", R.drawable.cheese, 2);
        shopItems.add(cheese);

        final Items chocolate = new Items("chocolate", R.drawable.chocolate, 1);
        shopItems.add(chocolate);

        final Items coffee = new Items("coffee", R.drawable.coffee, 4);
        shopItems.add(coffee);

        final Items donut = new Items("donut", R.drawable.donut, 3);
        shopItems.add(donut);

        final Items fries = new Items("fries", R.drawable.fries, 4);
        shopItems.add(fries);

        final Items honey = new Items("honey", R.drawable.honey, 1);
        shopItems.add(honey);

        final ListView listView = findViewById(R.id.list);

        final ItemAdapter itemAdapter = new ItemAdapter(this, 0, shopItems);

        listView.setAdapter(itemAdapter);

        // Navigate to a different activity when one of the items is clicked.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(MainActivity.this, DetailsView.class);
                intent.putExtra("item", (Serializable) shopItems.get(position));
                startActivity(intent);
            }
        });

        final ImageView addButton = findViewById(R.id.add_button);

        // Navigate to the add page when add button is clicked.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });
    }
}