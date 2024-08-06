package com.example.flavorfinder.Home;

import static com.example.flavorfinder.R.drawable.*;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.flavorfinder.Adapter.HomePopular;
import com.example.flavorfinder.R;
import com.example.flavorfinder.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeFragment extends Fragment {
    FragmentHomeBinding homeBinding;
    ArrayList<SlideModel> imageList;

   int[] itemImg={R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4};
   String[] itemName={"Burger","Sandwich","Momo","Item"};
   String[] price={"$5","$7","$8","$10"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homeBinding=FragmentHomeBinding.inflate(getLayoutInflater());
        }
        View view=homeBinding.getRoot();
        // Inflate the layout for this fragment
        imageList=new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.banner1,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3,ScaleTypes.FIT));

        homeBinding.imageSlider.setImageList(imageList);

        homeBinding.imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(getActivity(), "Banner"+imageList.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(int i) {

            }
        });

        setRecycler();

        return view;
    }

    public void setRecycler(){
        HomePopular popular=new HomePopular(getContext(),itemName,price,itemImg);
        homeBinding.recyclerPopular.setLayoutManager(new LinearLayoutManager(getContext()));
        homeBinding.recyclerPopular.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        homeBinding.recyclerPopular.setAdapter(popular);

    }
}