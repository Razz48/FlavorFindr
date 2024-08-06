package com.example.flavorfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flavorfinder.Login.LoginActivity;
import com.example.flavorfinder.databinding.ActivityStartBinding;

public class ActivityStart extends AppCompatActivity {

    ActivityStartBinding activityStartBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_start);
        activityStartBinding=ActivityStartBinding.inflate(getLayoutInflater());
        View view=activityStartBinding.getRoot();
        setContentView(view);

        activityStartBinding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityStart.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}