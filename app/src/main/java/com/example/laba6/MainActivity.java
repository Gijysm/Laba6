package com.example.laba6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Camera> cameras = new ArrayList<>();
    private ListView cameraList;
    private ArrayList<Camera> deletedItems = new ArrayList<>();
    private StateAdapter cameraAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        cameraList = findViewById(R.id.Printerslist);

        cameraAdapter = new StateAdapter(this, R.layout.list_item, cameras);

        cameraList.setAdapter(cameraAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Camera selectedCamera = (Camera) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selected camera " + selectedCamera.getModel(), Toast.LENGTH_SHORT).show();
            }
        };
        cameraList.setOnItemClickListener(itemClickListener);
    }

    public void onClick(View view) {
        deletedItems = cameraAdapter.getDeletedItems();
        Intent intent = new Intent(MainActivity.this, Trash.class);
        intent.putParcelableArrayListExtra("deletedItems", deletedItems);
        startActivity(intent);
    }

    private void setInitialData() {
        cameras.add(new Camera("Canon EOS R5", "Камера", "Canon", R.drawable.canon));
        cameras.add(new Camera("Nikon Z7 II", "Камера", "Nikon", R.drawable.nikon));
        cameras.add(new Camera("Sony A7 IV", "Камера", "Sony", R.drawable.sony));
        cameras.add(new Camera("Canon EOS-1D X Mark III", "Камера", "Canon", R.drawable.canon1));
        cameras.add(new Camera("Canon EOS Rebel T8i", "Камера", "Canon", R.drawable.canon2));
    }
}
