package com.example.texty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ttv1,vtt1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttv1 = findViewById(R.id.ttv);
        vtt1 = findViewById(R.id.vtt);
        ttv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spen = new Intent(MainActivity.this,tts.class);
                startActivity(spen);
            }
        });
      vtt1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent writ = new Intent(MainActivity.this,stt.class);
              startActivity(writ);
          }
      });

    }
}
