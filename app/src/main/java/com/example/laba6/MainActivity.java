package com.example.laba6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Printers> printers = new ArrayList<>();
    private ListView printerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Розкоментуйте цей рядок

        setInitialData();

        printerList = (ListView) findViewById(R.id.Printerslist);

        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, printers);

        printerList.setAdapter(stateAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Printers selectedPrinter = (Printers) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selected printer " + selectedPrinter.GetName(), Toast.LENGTH_SHORT).show();
            }
        };
        printerList.setOnItemClickListener(itemClickListener);
    }
    private void setInitialData(){
        printers.add(new Printers("HP LaserJet Pro", "M404dn", "HP", R.drawable.c08331728));
        printers.add(new Printers("PIXMA", "TS8320", "Canon", R.drawable.images));
        printers.add(new Printers("Epson EcoTank ET-4760", "ET-4760", "Epson", R.drawable.print));
        printers.add(new Printers("Brother HL-L2350DW", "HL-L2350DW", "Brother", R.drawable.brother));
//        "Samsung Xpress M2020W"
//        "Ricoh SP 3710DN"
//        "Kyocera ECOSYS P5026cdw"
//        "Xerox Phaser 6510"
//        "Lexmark B2236dw"
//        "Dell E310dw"
//        "OKI B432dn"
//        "HP OfficeJet Pro 9015"
//        "Canon imageCLASS MF644Cdw"
//        "Epson Workforce WF-2830"
//        "Brother MFC-J995DW"
//        "Samsung ProXpress SL-M3820DW"
//        "Ricoh SP C261SFNw"
//        "Kyocera TASKalfa 2552ci"
//        "Xerox VersaLink C400"
    }
}
