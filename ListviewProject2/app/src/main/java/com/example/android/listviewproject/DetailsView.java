package com.example.android.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);

        // Get the passed in shop item.
        final Items shopItem = (Items) getIntent().getSerializableExtra("item");

        final ImageView image = findViewById(R.id.img_view);
        final TextView title = findViewById(R.id.title_txt);
        final TextView price = findViewById(R.id.description_txt);

        image.setImageResource(shopItem.getItemImage());
        title.setText(shopItem.getItemName());
        price.setText(String.format("Price: %s", shopItem.getItemPrice()));
    }
}