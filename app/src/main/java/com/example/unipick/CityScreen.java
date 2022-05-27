package com.example.unipick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CityScreen extends AppCompatActivity {
    University[] asiaUnis = getAsiaUniversities();
    University[] africaUnis = getAfricaUniversities();
    University[] europeUnis = getEuropeUniversities();
    University[] oceaniaUnis = getOceaniaUniversities();
    University[][] allUnis = {asiaUnis,africaUnis,europeUnis,oceaniaUnis};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_screen);
        Button exitButton = findViewById(R.id.back_btn);
        exitButton.setOnClickListener(v -> {
            finish();
        });
        LinearLayout layout = (LinearLayout) findViewById(R.id.city_info_container);
        TextView uniName = (TextView) findViewById(R.id.uni_name);
        Intent intent=getIntent();
        int cityIndex = intent.getIntExtra("cityIndex",0);
        int continentIndex = intent.getIntExtra("continentIndex",0);
        uniName.setText(allUnis[continentIndex][cityIndex].name);
        // Handle website info
        Button webSite = new Button(this);
        webSite.setText("Website");
        webSite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(allUnis[continentIndex][cityIndex].websiteUrl));
                startActivity(websiteIntent);
            }
        });
        //Handle maps
        Button gMaps = new Button(this);
        gMaps.setText("Map");
        gMaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mapsIntent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse(allUnis[continentIndex][cityIndex].googleMapUrl));
                startActivity(mapsIntent);
            }
        });
        layout.addView(webSite);
        layout.addView(gMaps);
    }

    public University[] getAsiaUniversities (){
        University hongKongUni = new University("Hong Kong","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University tokyoUni = new University("Tokyo","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University seoulUni = new University("Seoul","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University singaporeUni = new University("Singapore","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University[] result = {hongKongUni,tokyoUni,seoulUni,singaporeUni};
        return result;
    }
    public University[] getEuropeUniversities (){
        University greeceUni = new University("Greece","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University italyUni = new University("Italy","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University franceUni = new University("France","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University germanyUni = new University("Germany","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University[] result = {greeceUni,italyUni,franceUni,germanyUni};
        return result;
    }
    public University[] getAfricaUniversities (){
        University capeTownUni = new University("Cape Town","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University cairoUni = new University("Cairo","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University johannesburgUni = new University("Johannesburg","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University nairobiUni = new University("Nairobi","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University[] result = {capeTownUni,cairoUni,johannesburgUni,nairobiUni};
        return result;
    }
    public University[] getOceaniaUniversities (){
        University melbourneTownUni = new University("Melbourne","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University sydneyUni = new University("Sydney","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University newcastleUni = new University("Newcastle","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University aucklandUni = new University("Auckland","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University[] result = {melbourneTownUni,sydneyUni,newcastleUni,aucklandUni};
        return result;
    }
}