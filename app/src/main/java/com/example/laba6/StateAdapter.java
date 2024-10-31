package com.example.laba6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<Printers> {
    private LayoutInflater inflater;
    private int layout;
    private List<Printers> states;


    public StateAdapter(Context context, int resource, List<Printers> states) {
        super(context, resource, states);
        this.states = states;
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

        Printers state = states.get(position);

        viewHolder.imageView.setImageResource(state.GetImageResourse());
        viewHolder.nameView.setText(state.GetName());
        viewHolder.modelView.setText(state.GetModel());
        viewHolder.companyView.setText(state.GetCompany());

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = state.Getcount() - 1;
                if (count < 0) count = 0;
                state.SetCount(count);
                viewHolder.countView.setText(formatValue(count, "units"));
            }
        });

        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = state.Getcount() + 1;
                state.SetCount(count);
                viewHolder.countView.setText(formatValue(count, "units"));
            }
        });

        return view;
    }

    private String formatValue(int count, String unit) {
        return count + " " + unit;
    }

    private static class ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView, modelView, countView;
        final Button addButton, removeButton;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.Img);
            nameView = view.findViewById(R.id.name);
            companyView = view.findViewById(R.id.company);
            modelView = view.findViewById(R.id.model);
            countView = view.findViewById(R.id.countView);
            addButton = view.findViewById(R.id.addButton);
            removeButton = view.findViewById(R.id.removeButton);
        }
    }
}
