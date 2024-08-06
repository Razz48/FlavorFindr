package com.example.flavorfinder;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.flavorfinder.Cart.CartFragment;
import com.example.flavorfinder.History.HistoryFragment;
import com.example.flavorfinder.Home.HomeFragment;
import com.example.flavorfinder.Search.SearchFragment;
import com.example.flavorfinder.User.UserFragment;
import com.example.flavorfinder.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=mainBinding.getRoot();
        setContentView(view);

//        replaceFragment(new HomeFragment());
       NavController navController= Navigation.findNavController(this,R.id.fragmentContainer);
        NavigationUI.setupWithNavController(mainBinding.bottomNavigation,navController);


    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        int id= item.getItemId();
//        if(id==R.id.homeFragment){
//            replaceFragment(new HomeFragment());
//        }
//        if(id==R.id.cartFragment){
//            replaceFragment(new CartFragment());
//        }
//        if(id==R.id.searchFragment){
//            replaceFragment(new SearchFragment());
//        }
//        if(id==R.id.historyFragment){
//            replaceFragment(new HistoryFragment());
//        }
//        if(id==R.id.userFragment){
//            replaceFragment(new UserFragment());
//        }
//
//        return true;
//    }
//
//    public void replaceFragment(Fragment fragment){
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.fragmentContainer,fragment);
//        ft.commit();
//    }
}