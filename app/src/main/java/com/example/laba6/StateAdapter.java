package com.example.laba6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StateAdapter extends ArrayAdapter<Vickend> {  // Use a common superclass or interface
    private LayoutInflater inflater;
    private int layout;
    private List<Vickend> items;  // Can be a List<Item>, assuming both Vickend and Printers implement Item
    private ArrayList<Vickend> deletedItems = new ArrayList<>();

    public ArrayList<Vickend> GetDeleted() {
        return deletedItems;
    }

    public StateAdapter(Context context, int resource, List<Vickend> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view;
        final ViewHolder viewHolder;

        if (convertView == null) {
            view = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Vickend item = items.get(position);

        viewHolder.imageView.setImageResource(item.GetImageResourse());
        viewHolder.nameView.setText(item.GetName());
        viewHolder.modelView.setText(item.GetModel());
        viewHolder.companyView.setText(item.GetCompany());
        viewHolder.countView.setText(formatValue(item.Getcount(), "units"));


        if (item instanceof Vickend) {
            Vickend printer = (Vickend) item;
            viewHolder.moneyView.setText(formatValue(printer.GetMoney(), "$"));
        } else {
            viewHolder.moneyView.setVisibility(View.GONE);  // Hide moneyView for Vickend
        }

        viewHolder.removeButton.setOnClickListener(v -> {
            int count = item.Getcount() - 1;
            if (count < 0) count = 0;
            item.SetCount(count);
            viewHolder.countView.setText(formatValue(count, "units"));
        });

        viewHolder.deleteButton.setOnClickListener(v -> {
            item.SetDeleted();
            boolean deleted = item.GetDeleted();
            if (deleted) {
                deletedItems.add(item);
                items.remove(position);
                notifyDataSetChanged();
            }
        });

        viewHolder.addButton.setOnClickListener(v -> {
            int count = item.Getcount() + 1;
            item.SetCount(count);
            viewHolder.countView.setText(formatValue(count, "units"));
        });

        return view;
    }

    private String formatValue(int count, String unit) {
        return count + " " + unit;
    }

    private static class ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView, modelView, countView, moneyView;
        final Button addButton, removeButton, deleteButton;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.Img);
            nameView = view.findViewById(R.id.name);
            companyView = view.findViewById(R.id.company);
            modelView = view.findViewById(R.id.model);
            countView = view.findViewById(R.id.countView);
            moneyView = view.findViewById(R.id.moneyView);  // Optional for Printers only
            addButton = view.findViewById(R.id.addButton);
            deleteButton = view.findViewById(R.id.deleteButton);
            removeButton = view.findViewById(R.id.removeButton);
        }
    }
}
