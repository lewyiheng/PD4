package com.example.pd4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class menuAdapter extends ArrayAdapter<menuObjects> {

    private ArrayList<menuObjects> menuObj;
    private Context context;
    private TextView title;
    private ImageView image;

    public  menuAdapter(Context context, int resource, ArrayList<menuObjects> objects){
        super(context, resource, objects);
        menuObj = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.menu_row,parent,false);

        menuObjects results = menuObj.get(position);

        title = rowView.findViewById(R.id.tvCategory);

        title.setText(results.getTitle());
        String setimage = results.getImage();
        //image.setImageResource(R.drawable.);

        return rowView;
}
}
