package com.example.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewConHolder extends AppCompatActivity {

    CustomViewSinHolder.Cheese[] cheeses = {
            new CustomViewSinHolder.Cheese("Parmesan", "Hard, granular cheese"),
            new CustomViewSinHolder.Cheese("Ricotta", "Italian whey cheese"),
            new CustomViewSinHolder.Cheese("Fontina", "Italian cow's milk cheese"),
            new CustomViewSinHolder.Cheese("Mozzarella", "Southern Italian buffalo milk cheese"),
            new CustomViewSinHolder.Cheese("Cheddar", "Firm, cow's milk cheese"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_item);

        android.widget.GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);

        cheeseGrid.setNumColumns(2);

        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);

        ArrayAdapter<CustomViewSinHolder.Cheese> cheeseAdapter =
                new ArrayAdapter<CustomViewSinHolder.Cheese>(this, 0, cheeses) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        CustomViewSinHolder.Cheese currentCheese = cheeses[position];
                        if(convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.custom_item, null, false);

                            ViewHolder viewHolder = new ViewHolder();
                            viewHolder.cheeseName =
                                    (TextView)convertView.findViewById(R.id.cheese_name);
                            viewHolder.cheeseDescription =
                                    (TextView)convertView.findViewById(R.id.cheese_description);
                            convertView.setTag(viewHolder);
                        }
                        TextView cheeseName =
                                (TextView)convertView.findViewById(R.id.cheese_name);
                        TextView cheeseDescription =
                                (TextView)convertView.findViewById(R.id.cheese_description);

                        cheeseName.setText(currentCheese.name);
                        cheeseDescription.setText(currentCheese.description);

                        return convertView;
                    }
                };
        cheeseGrid.setAdapter(cheeseAdapter);
    }


    static class Cheese {
        String name;
        String description;

        public Cheese(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    static class ViewHolder{
        TextView cheeseName;
        TextView cheeseDescription;
    }
}
