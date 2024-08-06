package com.example.flavorfinder;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flavorfinder.databinding.ActivityOrderPlaceBinding;

public class OrderPlaceActivity extends AppCompatActivity {
    ActivityOrderPlaceBinding orderPlaceBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderPlaceBinding=ActivityOrderPlaceBinding.inflate(getLayoutInflater());
        View view= orderPlaceBinding.getRoot();
        setContentView(view);
//        setContentView(R.layout.activity_order_place);

        setTextColor(orderPlaceBinding.edittext,getResources().getColor(R.color.startColor),getResources().getColor(R.color.endColor));

    }

    private void setTextColor(TextView text,int...color){
        TextPaint paint=text.getPaint();
        float width=paint.measureText(text.getText().toString());
        Shader shader=new LinearGradient(0,0,width,text.getTextSize(),color,null,Shader.TileMode.CLAMP);
        text.getPaint().setShader(shader);
        text.setTextColor(color[0]);
    }
}