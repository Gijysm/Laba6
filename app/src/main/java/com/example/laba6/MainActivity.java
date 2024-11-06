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

    private List<Vickend> printers = new ArrayList<>();
    private ListView printerList;
    private ArrayList<Vickend> deletedItems = new ArrayList<>();
    private StateAdapter stateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        printerList = (ListView) findViewById(R.id.Printerslist);

        stateAdapter = new StateAdapter(this, R.layout.list_item, printers);

        printerList.setAdapter(stateAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vickend selectedPrinter = (Vickend) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selected printer " + selectedPrinter.GetName(), Toast.LENGTH_SHORT).show();
            }
        };
        printerList.setOnItemClickListener(itemClickListener);
    }
    public void OnClick(View view)
    {
        deletedItems = stateAdapter.GetDeleted();
            Intent intent = new Intent(MainActivity.this, Trash.class);
            intent.putParcelableArrayListExtra("deletedItems", deletedItems);
            startActivity(intent);
    }
    private void setInitialData(){
        printers.add(new Vickend("Відвідування старого міста Кракова", "Екскурсія", "Краків", R.drawable.krakow));
        printers.add(new Vickend("Тур до Варшави", "Міський тур", "Варшава", R.drawable.warsaw));
        printers.add(new Vickend("Поход до гір Татри", "Поход", "Татри", R.drawable.tatras));
        printers.add(new Vickend("Екскурсія до Вавельського замку", "Екскурсія", "Вавель", R.drawable.wawel_castle));
        printers.add(new Vickend("Відпочинок на Балтійському узбережжі", "Курорт", "Балтійське море", R.drawable.baltic_sea));
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
