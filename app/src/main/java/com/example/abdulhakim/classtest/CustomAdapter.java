package com.example.abdulhakim.classtest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulhakim on 04/03/2017.
 */

public class CustomAdapter extends ArrayAdapter<Restaurant> {
    String ra;
    private Context context;
    private List<Restaurant> places;

    public CustomAdapter(Context context,int resource,  ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.context = context;
        this.places = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        Restaurant restaurant = places.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_layout, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView address1 = (TextView) view.findViewById(R.id.address1);
        TextView menu = (TextView) view.findViewById(R.id.menu);
        TextView price = (TextView) view.findViewById(R.id.price);
        TextView phone = (TextView) view.findViewById(R.id.phone);
        TextView rate = (TextView) view.findViewById(R.id.rate);
        name.setText("Name " + restaurant.getName());
        address1.setText("Address " +restaurant.getAddress1());
        menu.setText("Cuisine "+restaurant.getMenu_type());
        price.setText("Price " + Integer.toString(restaurant.getCost()));
        phone.setText("Phone " +Integer.toString(restaurant.getPhone()));
        rate.setText( "Rate " +Float.toString(restaurant.getRate()));


        return view;
    }
}
