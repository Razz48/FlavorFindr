package com.example.flavorfinder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flavorfinder.R;

public class HomePopular extends RecyclerView.Adapter<HomePopular.ViewHolder> {

    Context context;
    String[] itemName;
    String[] price;
    int[] itemImg;


    public HomePopular( Context context,String[] itemName,String[] price, int[] itemImg){
        this.context=context;
        this.itemImg=itemImg;
        this.itemName=itemName;
        this.price=price;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.popular_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(itemName[position]);
        holder.price.setText(price[position]);
        Glide.with(context).load(itemImg[position]).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return itemImg.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView title,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=(ImageView) itemView.findViewById(R.id.popularImg);
            title=(TextView) itemView.findViewById(R.id.textView3);
            price=(TextView) itemView.findViewById(R.id.textPrice);
//            title=(TextView) itemView.findViewById(R.id.addToCart);
        }
    }
}
