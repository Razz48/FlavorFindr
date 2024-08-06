package com.example.flavorfinder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flavorfinder.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    Context context;

    List<Integer> itemImg;
    List<String> itemName;
    List<String> price;
    List<Integer> quantities;

    public CartItemAdapter(Context context, List<Integer> itemImg,List<String> itemName, List<String> price,List<Integer> quantities) {
        this.context=context;
        this.itemImg = new ArrayList<>(itemImg);
        this.itemName = new ArrayList<>(itemName);
        this.price = new ArrayList<>(price);
        this.quantities = new ArrayList<>(quantities);

        while (this.quantities.size() < itemImg.size()) {
            this.quantities.add(0);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cart_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(itemImg.get(position)).into(holder.foodImage);
        holder.foodName.setText(itemName.get(position));
        holder.quantity.setText(String.valueOf(quantities.get(position)));
        holder.price.setText(price.get(position));

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               increaseQuantity(position,holder.quantity);
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity(position,holder.quantity);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return itemImg.size();
    }
    private void increaseQuantity(int position,TextView quantity){
        int newQuantity=quantities.get(position)+1;
        quantities.set(position,newQuantity);

        quantity.setText(String.valueOf(newQuantity));

    }
    private void decreaseQuantity(int position,TextView quantity){
        int newQuantity=quantities.get(position)-1;
        if(quantities.get(position)>0){
            quantities.set(position,newQuantity);
            quantity.setText(String.valueOf(newQuantity));
        }
    }
    private void deleteItem(int position){
        itemName.remove(position);
        itemImg.remove(position);
        price.remove(position);
        quantities.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,itemImg.size());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        ImageButton plus,minus,delete;

        TextView foodName,price,quantity;
        ConstraintLayout itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage=(ImageView) itemView.findViewById(R.id.cartImage);
            foodName=(TextView) itemView.findViewById(R.id.foodName);
            price=(TextView) itemView.findViewById(R.id.textPrice);
            quantity=(TextView) itemView.findViewById(R.id.quantity);
            plus=(ImageButton) itemView.findViewById(R.id.plusbtn);
            minus=(ImageButton) itemView.findViewById(R.id.minusbtn);
            delete=(ImageButton) itemView.findViewById(R.id.deletebtn);
            itemLayout=(ConstraintLayout) itemView.findViewById(R.id.oneItem);

        }
    }

}
