package com.example.lifecyclestatehomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvCounter;
    private EditText etDoesNothing;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        etDoesNothing = findViewById(R.id.etDoesNothing);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt("counter");
        }
        tvCounter.setText("" + counter);
    }

    public void incrementCounter(View view){
        counter++;
        tvCounter.setText("" + counter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}
