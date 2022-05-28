package com.example.unipick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
        University hongKongUni = new University("Hong Kong National University","https://www.hku.hk/","https://www.google.com/maps?q=hong+kong+university&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjh666NzID4AhU_if0HHV3YD1AQ_AUoAnoECAIQBA");
        University tokyoUni = new University("Tokyo National University","https://www.u-tokyo.ac.jp/en/","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%A4%CF%8C%CE%BA%CE%B9%CE%BF/@35.7126775,139.7598003,17z/data=!3m1!4b1!4m5!3m4!1s0x60188c2ffa206ea3:0x30e407498313ba95!8m2!3d35.7126775!4d139.761989");
        University seoulUni = new University("Seoul National University","https://en.snu.ac.kr/","https://www.google.com/maps/place/Seoul+National+University/@37.4565137,126.9455538,17z/data=!3m1!4b1!4m5!3m4!1s0x357c9fe8a0a1e2a5:0xa1e2eebc04f0c5e7!8m2!3d37.4565095!4d126.9500385");
        University singaporeUni = new University("Singapore National University","https://www.nus.edu.sg/","https://www.google.com/maps/place/Singapore+University+of+Social+Sciences/@1.3290864,103.771712,17z/data=!3m2!4b1!5s0x31da1a813838c19d:0xb65b7dc12b1f607a!4m5!3m4!1s0x31da1080893304bd:0xd93738a024fee308!8m2!3d1.329081!4d103.7761967");
        University[] result = {hongKongUni,tokyoUni,seoulUni,singaporeUni};
        return result;
    }
    public University[] getEuropeUniversities (){
        University greeceUni = new University("Auth University","https://www.auth.gr/","https://www.google.com/maps/place/%CE%91%CF%81%CE%B9%CF%83%CF%84%CE%BF%CF%84%CE%AD%CE%BB%CE%B5%CE%B9%CE%BF+%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CE%98%CE%B5%CF%83%CF%83%CE%B1%CE%BB%CE%BF%CE%BD%CE%AF%CE%BA%CE%B7%CF%82/@40.6308324,22.9570337,17z/data=!3m1!4b1!4m5!3m4!1s0x14a838ff432792c9:0x15eefe1dc3e6c8e9!8m2!3d40.6308283!4d22.9592224");
        University italyUni = new University("Bologna University","https://www.unibo.it/en","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%B7%CF%82+%CE%9C%CF%80%CE%BF%CE%BB%CF%8C%CE%BD%CE%B9%CE%B1%CF%82/@44.4975857,11.3376289,15z/data=!4m9!1m2!2m1!1sUniversity+of+Bologna!3m5!1s0x477fd4bb9753a277:0xac40824c35d31af1!8m2!3d44.4962318!4d11.354157!15sChVVbml2ZXJzaXR5IG9mIEJvbG9nbmGSAQp1bml2ZXJzaXR5");
        University franceUni = new University("Sorbonne University","https://www.sorbonne-universite.fr/en","https://www.google.com/maps/place/Sorbonne+Universit%C3%A9/@48.8505515,2.3403275,15z/data=!4m2!3m1!1s0x0:0xfecd14d84c0a92b5?sa=X&ved=2ahUKEwjg1sfdxIL4AhV08LsIHXrmBaoQ_BJ6BAhgEAU");
        University germanyUni = new University("Heidelberg University","https://www.uni-heidelberg.de/en","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%B7%CF%82+%CE%A7%CE%B1%CF%8A%CE%B4%CE%B5%CE%BB%CE%B2%CE%AD%CF%81%CE%B3%CE%B7%CF%82/@49.4190991,8.6702507,15z/data=!4m5!3m4!1s0x0:0x127da0a49afc15!8m2!3d49.4190991!4d8.6702507");
        University[] result = {greeceUni,italyUni,franceUni,germanyUni};
        return result;
    }
    public University[] getAfricaUniversities (){
        University capeTownUni = new University("Cape town university","https://www.uct.ac.za/","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%9A%CE%AD%CE%B9%CF%80+%CE%A4%CE%AC%CE%BF%CF%85%CE%BD/@-33.957652,18.4611991,15z/data=!4m2!3m1!1s0x0:0x5f90e4dc19b5fa4e?sa=X&ved=2ahUKEwjdr8yoxYL4AhX1iP0HHbpTA5cQ_BJ6BAhiEAU");
        University cairoUni = new University("Cairo University","https://cu.edu.eg/Home","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%9A%CE%B1%CE%90%CF%81%CE%BF%CF%85/@30.0272927,31.2085406,15z/data=!4m2!3m1!1s0x0:0xbd9781bf40115c5d?sa=X&ved=2ahUKEwj40cfFxYL4AhUlgv0HHWcPD7oQ_BJ6BAhnEAU");
        University johannesburgUni = new University("Johannesburg University","https://www.uj.ac.za//","https://www.google.com/maps/place/University+of+Johannesburg+-+Soweto+Campus/@-26.2613931,27.9181096,17z/data=!3m1!4b1!4m5!3m4!1s0x1e95a77dd02f6d83:0x3ef41126b2c7ddd8!8m2!3d-26.261398!4d27.9225943");
        University nairobiUni = new University("Nairobi University","https://www.uonbi.ac.ke/","https://www.google.com/maps/place/University+Of+Nairobi+-+Kikuyu+Campus/@-1.2699383,36.6772993,12z/data=!4m5!3m4!1s0x182f1e958b920b3b:0xc3bce323dcad7a87!8m2!3d-1.2668964!4d36.6733439");
        University[] result = {capeTownUni,cairoUni,johannesburgUni,nairobiUni};
        return result;
    }
    public University[] getOceaniaUniversities (){
        University melbourneTownUni = new University("Melbourne University","https://www.unimelb.edu.au/","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%B7%CF%82+%CE%9C%CE%B5%CE%BB%CE%B2%CE%BF%CF%8D%CF%81%CE%BD%CE%B7%CF%82/@-37.7983459,144.960974,15z/data=!4m2!3m1!1s0x0:0xeacb63e2b725ff6d?sa=X&ved=2ahUKEwiE9uaIxoL4AhUpiP0HHRn9AlEQ_BJ6BAhdEAU");
        University sydneyUni = new University("Sydney University","https://www.westernsydney.edu.au/","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%A3%CE%AF%CE%B4%CE%BD%CE%B5%CF%8B/@-33.8885703,151.1851607,17z/data=!3m1!4b1!4m5!3m4!1s0x6b12b1d4ab9ef1d9:0x1d017d69037a07c0!8m2!3d-33.8885748!4d151.1873494");
        University newcastleUni = new University("Newcastle University","https://www.ncl.ac.uk/","https://www.google.com/maps/place/%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%9D%CE%B9%CE%BF%CF%8D%CE%BA%CE%B1%CF%83%CF%84%CE%BB/@-32.8927673,151.7019888,17z/data=!3m1!4b1!4m5!3m4!1s0x6b731468030c4271:0x14f86d28506eb988!8m2!3d-32.8927718!4d151.7041775");
        University aucklandUni = new University("Auckland University","https://www.auckland.ac.nz/en.html","https://www.google.com/maps/place/%CE%A4%CE%B5%CF%87%CE%BD%CE%BF%CE%BB%CE%BF%CE%B3%CE%B9%CE%BA%CF%8C+%CE%A0%CE%B1%CE%BD%CE%B5%CF%80%CE%B9%CF%83%CF%84%CE%AE%CE%BC%CE%B9%CE%BF+%CF%84%CE%BF%CF%85+%CE%8F%CE%BA%CE%BB%CE%B1%CE%BD%CF%84/@-36.8536055,174.7642918,17z/data=!3m1!4b1!4m5!3m4!1s0x6d0d47e463e6c953:0xe08f185abdafcdbd!8m2!3d-36.8536098!4d174.7664805");
        University[] result = {melbourneTownUni,sydneyUni,newcastleUni,aucklandUni};
        return result;
    }
}