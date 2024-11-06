package com.example.laba6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Trash extends AppCompatActivity {
    private ListView deletedItemsListView;
    private StateAdapter adapter;
    private ArrayList<Camera> deletedItems;
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


        deletedItemsListView = findViewById(R.id.deleted_items_list);

        adapter = new StateAdapter(this, R.layout.list_item, deletedItems);

        deletedItemsListView.setAdapter(adapter);
    }
}