package com.example.flavorfinder.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flavorfinder.Location.LocationActivity;
import com.example.flavorfinder.MainActivity;
import com.example.flavorfinder.Register.RegisterActivity;
import com.example.flavorfinder.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        activityLoginBinding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view=activityLoginBinding.getRoot();
        setContentView(view);
        String or="Or";
        String continueWith="\nContinue With";
        SpannableString spannableString=new SpannableString(or+continueWith);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), 0 ,or.length() , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.2f) ,or.length() ,(or+continueWith).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        activityLoginBinding.OrContinueWith.setText(spannableString);

        activityLoginBinding.loginEmail.getEditText().getText().toString();
        activityLoginBinding.loginPassword.getEditText().getText().toString();


        activityLoginBinding.loginEmail.getEditText().setText("");
        activityLoginBinding.loginPassword.getEditText().setText("");
        activityLoginBinding.forRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        activityLoginBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(LoginActivity.this, MainActivity.class);
               startActivity(i);
            }
        });


    }
}