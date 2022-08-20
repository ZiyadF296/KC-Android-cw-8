package com.example.android.listviewproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class ItemAdapter extends ArrayAdapter<Items> {
    List<Items> items;

    final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        this.items = objects;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.list_item1, parent, false);

        final Items currentItem = items.get(position);

        final TextView shapeNameTextView = view.findViewById(R.id.item1_name);
        shapeNameTextView.setText(currentItem.getItemName());

        final ImageView shapeImageTextView = view.findViewById(R.id.item1_image);
        shapeImageTextView.setImageResource(currentItem.getItemImage());

        final TextView price = view.findViewById(R.id.item1_price);
        price.setText(String.valueOf(currentItem.getItemPrice()));

        final ImageView deleteButton = view.findViewById(R.id.delete_img);

        // We will listen for on click to the [deleteButton] and before removing the current
        // item from the list, we will show a dialog to confirm to the user.
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setTitle("Delete Item");
                alert.setMessage("Are you sure you want to delete this item?");
                alert.setPositiveButton("Yes", (dialog, which) -> {
                    items.remove(currentItem);
                    notifyDataSetChanged();

                    // Show a snackbar to the user.
                    Toast.makeText(getContext(), "Item has been deleted.", Toast.LENGTH_SHORT).show();
                });
                alert.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                alert.show();
            }
        });

        return view;
    }
}
