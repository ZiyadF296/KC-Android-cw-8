package com.example.android.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final EditText pName = findViewById(R.id.p_name);
        final EditText pPrice = findViewById(R.id.p_price);


        final Button addButton = findViewById(R.id.confirm_button);

        // Navigate to the add page when add button is clicked after adding the item.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Items newItem = new Items(pName.getText().toString(), R.drawable.cheese, Integer.parseInt(pPrice.getText().toString()));

                final Intent intent = new Intent(AddItem.this, MainActivity.class);
                intent.putExtra("item", newItem);
                startActivity(intent);
            }
        });
    }
}