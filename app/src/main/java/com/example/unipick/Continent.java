package com.example.unipick;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Continent {
    String name;
    Country[] countries;

    public Continent(String name, Country[] countries){
        this.name = name;
        this.countries = countries;
    }
}
