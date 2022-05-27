package com.example.unipick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;

public class CitiesScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_screen);
        Button exitButton = findViewById(R.id.back_btn);
        exitButton.setOnClickListener(v -> {
            finish();
        });
        LinearLayout layout = (LinearLayout) findViewById(R.id.cities_container);
        Intent intent=getIntent();
        int continentIdx = intent.getIntExtra("selectedIdx",0);
        String[] cities = intent.getStringArrayExtra("options");
        for(int i=0;i<cities.length;i++){
            Button c = new Button(this);
            c.setText(cities[i]);
            final int index = i;
            c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showCityOptions(continentIdx,index);
                }
            });
            layout.addView(c);
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    public void showCityOptions(int continentIndex,int cityIndex ){
        Intent intent = new Intent(this, CityScreen.class);
        intent.putExtra("cityIndex",cityIndex);
        intent.putExtra("continentIndex",continentIndex);
        startActivity(intent);
    }
}