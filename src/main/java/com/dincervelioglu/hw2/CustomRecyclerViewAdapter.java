package com.dincervelioglu.hw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomRecyclerViewItemHolder> {
    private Context context;
    private ArrayList<Gym> recyclerItemValues;

    public CustomRecyclerViewAdapter(Context context, ArrayList<Gym> values) {
        this.context = context;
        this.recyclerItemValues = values;
    }

    @NonNull
    @Override
    public CustomRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflator.inflate(R.layout.recycler_layout, viewGroup, false);
        CustomRecyclerViewItemHolder itemViewHolder = new CustomRecyclerViewItemHolder(itemView);
        return itemViewHolder;
    }

    public void openOtherActivity(Gym gm, Intent intent){
        Bundle b = new Bundle();
        b.putParcelable("Object", gm);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewItemHolder itemViewHolder, int i) {
        final Gym item = recyclerItemValues.get(i);

        final Intent intent = new Intent(context, SecondActivity.class);

        itemViewHolder.tvItemName.setText(item.getName());
        itemViewHolder.tvItemPlace.setText(item.getEquipment());
        itemViewHolder.imgItem.setImageResource(item.getImgId());



        itemViewHolder.parentItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOtherActivity(item,intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    class CustomRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView tvItemName, tvItemPlace;
        ImageView imgItem;
        ConstraintLayout parentItemLayout;

        public CustomRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);

            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPlace = itemView.findViewById(R.id.tvItemPlace);
            imgItem = itemView.findViewById(R.id.imgItem);
            parentItemLayout = itemView.findViewById(R.id.constLayout);
        }
    }
}