package com.example.pd4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class gameAdapter extends ArrayAdapter<gameObjects> {

    private ArrayList<gameObjects> gameObj;
    private Context context;
    private TextView name;
    private ImageView image;
    private TextView discount;
    private TextView price;

    public gameAdapter(Context context, int resource, ArrayList<gameObjects> objects){
        super(context, resource, objects);
        gameObj = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.menu_row,parent,false);

        gameObjects results = gameObj.get(position);

        name = rowView.findViewById(R.id.tvGame);

        name.setText(results.getName());

        return rowView;
    }
}
