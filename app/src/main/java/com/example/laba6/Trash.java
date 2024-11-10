package com.example.laba6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Trash extends AppCompatActivity {
    private ListView deletedItemsListView;
    private StateAdapter adapter;
    private ArrayList<Vickend> deletedItems;
    private Button Back_Button, Accept_Button;
    private TextView Text_All, Text_Solo_obj;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trash);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        deletedItems = getIntent().getParcelableArrayListExtra("deletedItems");


        Back_Button = findViewById(R.id.Back);
        Accept_Button = findViewById(R.id.Buy);
        Text_All = findViewById(R.id.textAllMatch);
        Text_Solo_obj = findViewById(R.id.textSoloMatch);

        deletedItemsListView = findViewById(R.id.deleted_items_list);
        adapter = new StateAdapter(this, R.layout.list_item, deletedItems);


        updateTextFields();


        deletedItemsListView.setAdapter(adapter);


        Back_Button.setOnClickListener(v -> finish());


        Accept_Button.setOnClickListener(v -> finish());
    }

    private void updateTextFields() {

        StringBuilder individualItemsText = new StringBuilder();
        int totalPrice = 0;


        for (Vickend printer : deletedItems) {
            int itemTotal = printer.GetAllBuyed();
            totalPrice += itemTotal;

            individualItemsText.append(printer.GetName())
                    .append(" - $")
                    .append(itemTotal)
                    .append("\n");
        }


        Text_All.setText("Total Price: $" + totalPrice);
        Text_Solo_obj.setText(individualItemsText.toString().trim());
    }
}
