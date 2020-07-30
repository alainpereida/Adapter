package com.example.adapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ListView extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        String[] cheeses = getResources().getStringArray(R.array.cheese);

        ArrayAdapter<String> cheeseAdapter =
                new ArrayAdapter<String>(this,
                        R.layout.item,
                        R.id.cheese_name,
                        cheeses);

        android.widget.ListView cheeseList = new android.widget.ListView(this);

        setContentView(cheeseList);

        cheeseList.setAdapter(cheeseAdapter);
    }
}
