package com.example.unipick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Button exitButton = findViewById(R.id.exit_btn);
        exitButton.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

    }
    public void showContinentsScreen(View view) {
        Intent intent = new Intent(this, ShowContinents.class);
        startActivity(intent);
    }




}