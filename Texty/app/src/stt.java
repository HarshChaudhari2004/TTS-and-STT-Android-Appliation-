package com.example.texty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class stt extends AppCompatActivity {

    private final int REQ_CODE = 100;
    ImageView mic;
    TextView texic;

    SpeechRecognizer speechRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stt);

        mic = findViewById(R.id.imageButton3);
        texic = findViewById(R.id.textviewy);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seek = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                seek.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                seek.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                seek.putExtra(RecognizerIntent.EXTRA_PROMPT, "Listening....");
                startActivityForResult(seek, REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<String> resultList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String resultText = resultList.get(0);
            texic.setText(resultText);
        }
    }
}
