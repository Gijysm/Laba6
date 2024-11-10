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

        // Обробка відступів для системних панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Отримання списку видалених елементів із Intent
        deletedItems = getIntent().getParcelableArrayListExtra("deletedItems");

        // Ініціалізація кнопок і текстових полів
        Back_Button = findViewById(R.id.Back);
        Accept_Button = findViewById(R.id.Buy);
        Text_All = findViewById(R.id.textAllMatch);
        Text_Solo_obj = findViewById(R.id.textSoloMatch);

        // Ініціалізація ListView і адаптера
        deletedItemsListView = findViewById(R.id.deleted_items_list);
        adapter = new StateAdapter(this, R.layout.list_item, deletedItems);

        // Оновлення текстових полів
        updateTextFields();

        // Встановлення адаптера для ListView
        deletedItemsListView.setAdapter(adapter);

        // Обробка натискання кнопки "Назад"
        Back_Button.setOnClickListener(v -> finish());

        // Обробка натискання кнопки "Прийняти"
        Accept_Button.setOnClickListener(v -> finish());
    }

    private void updateTextFields() {
        // Оновлення текстових полів для відображення сумарної ціни та індивідуальних покупок
        StringBuilder individualItemsText = new StringBuilder();
        int totalPrice = 0;

        // Обчислення ціни для кожного елемента
        for (Vickend printer : deletedItems) {
            int itemTotal = printer.GetAllBuyed();
            totalPrice += itemTotal;

            individualItemsText.append(printer.GetName())
                    .append(" - $")
                    .append(itemTotal)
                    .append("\n");
        }

        // Відображення загальної ціни та індивідуальних покупок
        Text_All.setText("Total Price: $" + totalPrice);
        Text_Solo_obj.setText(individualItemsText.toString().trim());
    }
}
