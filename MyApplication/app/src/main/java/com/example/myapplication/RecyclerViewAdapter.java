package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> nameList;
    private ArrayList<Integer> imageList;
    private ArrayList<String> priceList;

    public RecyclerViewAdapter(ArrayList<String> nameList, ArrayList<Integer> imageList, ArrayList<String> priceList) {
        this.nameList = nameList;
        this.imageList = imageList;
        this.priceList = priceList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mItemName, mItemPrice;
        private ImageView mItemImage;
        private RelativeLayout mItemList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemName = itemView.findViewById(R.id.item_name);
            mItemPrice = itemView.findViewById(R.id.item_price);
            mItemImage = itemView.findViewById(R.id.item_image);
            mItemList = itemView.findViewById(R.id.item_list);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mItemName.setText(nameList.get(position));
        holder.mItemPrice.setText(priceList.get(position));
        holder.mItemImage.setImageResource(imageList.get(position));

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

}
