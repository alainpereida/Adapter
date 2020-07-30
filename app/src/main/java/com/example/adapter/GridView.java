package com.example.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GridView extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        final String[] cheeses = getResources().getStringArray(R.array.cheese);

        ArrayAdapter<String> cheeseAdapter =
                new ArrayAdapter<String>(this,
                        R.layout.item,
                        R.id.cheese_name,
                        cheeses);

        android.widget.GridView cheeseList = new android.widget.GridView(this);

        setContentView(cheeseList);

        cheeseList.setNumColumns(2);
        cheeseList.setColumnWidth(60);
        cheeseList.setVerticalSpacing(20);
        cheeseList.setHorizontalSpacing(20);

        cheeseList.setAdapter(cheeseAdapter);

        cheeseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Click en " + cheeses[position];

                Toast.makeText(view.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
