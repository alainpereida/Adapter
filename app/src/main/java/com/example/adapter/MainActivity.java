package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA, buttonB, buttonC, buttonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonA:
                intent = new Intent(MainActivity.this, ListView.class);
                startActivity(intent);
            break;

            case R.id.buttonB:
                intent = new Intent(MainActivity.this, GridView.class);
                startActivity(intent);
                break;

            case R.id.buttonC:
                intent = new Intent(MainActivity.this, CustomViewSinHolder.class);
                startActivity(intent);
                break;

            case R.id.buttonD:
                intent = new Intent(MainActivity.this, CustomViewConHolder.class);
                startActivity(intent);
                break;
        }
    }
}
