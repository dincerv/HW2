package com.dincervelioglu.hw2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Gym> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;
    private ArrayList<Gym>  gymExercises;

    private boolean flag=false;

    public SpinnerAdapter(Context baseContext, int gymspinner_layout, ArrayList<Gym> gymArrayList) {
        super(baseContext, gymspinner_layout, gymArrayList);
        this.context = baseContext;
        this.layoutResourceId = gymspinner_layout;
        gymExercises = gymArrayList;
    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflator.inflate(layoutResourceId,parent,false);
        }

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemLayout);
        TextView tv_main = rowView.findViewById(R.id.tvItemMain);
        ImageView leftPic = rowView.findViewById(R.id.imgItemleftPic);

        tv_main.setText(gymExercises.get(position).getName());
        leftPic.setImageResource(gymExercises.get(position).getImgId());

        return rowView;
    }

}
