package com.example.spdsosialdanphysicaldistance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spdsosialdanphysicaldistance.R;

public class MainActivity extends AppCompatActivity {
    Button startTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTest = findViewById(R.id.bt_startTest);

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mulaiTest = new Intent(MainActivity.this, DataMasukGedung.class);
                startActivity(mulaiTest);
            }
        });
    }
}