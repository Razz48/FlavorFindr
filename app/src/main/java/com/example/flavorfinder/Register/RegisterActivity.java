package com.example.flavorfinder.Register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flavorfinder.Login.LoginActivity;
import com.example.flavorfinder.R;
import com.example.flavorfinder.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding registerBinding;
    String or="Or";
    String continueWith="\nContinue With";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
        registerBinding=ActivityRegisterBinding.inflate(getLayoutInflater());
        View view=registerBinding.getRoot();
        setContentView(view);


        SpannableString spannableString=new SpannableString(or+continueWith);
        spannableString.setSpan(new RelativeSizeSpan(0.8f),0,or.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.2f),or.length(),(or+continueWith).length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        registerBinding.OrContinueWith.setText(spannableString);


        registerBinding.forLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}