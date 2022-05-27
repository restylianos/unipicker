package com.example.unipick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Arrays;

public class ShowContinents extends AppCompatActivity {

    String[] asiaCountries = {"Hong Kong","Tokyo","Seoul","Singapore"};
    String[] africaCountries = {"Cape Town","Cairo","Johannesburg","Nairobi"};
    String[] europeCountries = {"Greece","Italy","France","Germany"};
    String[] oceaniaCountries = {"Melbourne","Sydney","Newcastle","Auckland"};
    String[] continents = {"Asia","Africa","Europe","Oceania"};
    String[][] countriesHelper = {asiaCountries,africaCountries,europeCountries,oceaniaCountries};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_continents);

        LinearLayout layout = (LinearLayout) findViewById(R.id.continents_container);
        for(int i=0;i<continents.length;i++){
            Button c = new Button(this);
            c.setText(continents[i]);
            final int index = i;
            c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showCityInformation(index);
                }
            });
            layout.addView(c);
        }

        Button exitButton = findViewById(R.id.back_btn);
        exitButton.setOnClickListener(v -> {
            finish();
        });
    }

    protected void onStart()
    {
        super.onStart();
    }

    public void showCityInformation(int index){
        Intent intent = new Intent(this, CitiesScreen.class);
        intent.putExtra("selectedIdx",index);
        intent.putExtra("options",countriesHelper[index]);
        startActivity(intent);
    }


}