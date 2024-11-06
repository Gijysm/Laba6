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

public class StateAdapter extends ArrayAdapter<Camera> {
    private LayoutInflater inflater;
    private int layout;
    private List<Camera> cameras;
    private ArrayList<Camera> deletedItems = new ArrayList<>();

    public ArrayList<Camera> getDeletedItems() {
        return deletedItems;
    }

    public StateAdapter(Context context, int resource, List<Camera> cameras) {
        super(context, resource, cameras);
        this.cameras = cameras;
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

        Camera camera = cameras.get(position);

        viewHolder.imageView.setImageResource(camera.getImageResource());
        viewHolder.nameView.setText(camera.getModel());
        viewHolder.modelView.setText(camera.getType());
        viewHolder.companyView.setText(camera.getCompany());

        viewHolder.removeButton.setOnClickListener(v -> {
            int count = camera.getCount() - 1;
            if (count < 0) count = 0;
            camera.setCount(count);
            viewHolder.countView.setText(formatValue(count, "units"));
        });

        viewHolder.deleteButton.setOnClickListener(v -> {
            camera.toggleDeleted();
            if (camera.isDeleted()) {
                deletedItems.add(camera);
                cameras.remove(camera);
                notifyDataSetChanged();
            }
        });

        viewHolder.addButton.setOnClickListener(v -> {
            int count = camera.getCount() + 1;
            camera.setCount(count);
            viewHolder.countView.setText(formatValue(count, "units"));
        });

        return view;
    }

    private String formatValue(int count, String unit) {
        return count + " " + unit;
    }

    private static class ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView, modelView, countView;
        final Button addButton, removeButton, deleteButton;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.Img);
            nameView = view.findViewById(R.id.name);
            companyView = view.findViewById(R.id.company);
            modelView = view.findViewById(R.id.model);
            countView = view.findViewById(R.id.countView);
            addButton = view.findViewById(R.id.addButton);
            deleteButton = view.findViewById(R.id.deleteButton);
            removeButton = view.findViewById(R.id.removeButton);
        }
    }
}
