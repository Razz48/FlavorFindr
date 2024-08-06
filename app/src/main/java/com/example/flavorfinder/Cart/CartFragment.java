package com.example.flavorfinder.Cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flavorfinder.Adapter.CartItemAdapter;
import com.example.flavorfinder.OrderPlaceActivity;
import com.example.flavorfinder.R;
import com.example.flavorfinder.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    FragmentCartBinding cartBinding;
    List<Integer> itemImg= new ArrayList<>();
    List<String> itemName=new ArrayList<>();
   List<String> price=new ArrayList<>();
    List<Integer> quantities=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        cartBinding = FragmentCartBinding.inflate(inflater, container, false);
        View view = cartBinding.getRoot();
//        cartBinding=FragmentCartBinding.inflate(getLayoutInflater());
//        View view=cartBinding.getRoot();
        // Inflate the layout for this fragment
//        View view=inflater.inflate(R.layout.fragment_cart, container, false);
        itemImg.add(R.drawable.menu1);
        itemImg.add(R.drawable.menu2);
        itemImg.add(R.drawable.menu3);
        itemImg.add(R.drawable.menu4);

        itemName.add("Burger");
        itemName.add("Sandwich");
        itemName.add("Momo");
        itemName.add("Item");

        price.add("$5");
        price.add("$7");
        price.add("$8");
        price.add("$10");

        setRecycler();

        cartBinding.proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), OrderPlaceActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

    public void setRecycler(){
        if (getContext() != null) {
            CartItemAdapter cartItemAdapter = new CartItemAdapter(getActivity(), itemImg, itemName, price, quantities);
            cartBinding.cartRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            cartBinding.cartRecycler.setAdapter(cartItemAdapter);
        } else {
            // Handle null context situation if needed
            Log.e("CartFragment", "Context is null in setRecycler()");
        }
    }
}