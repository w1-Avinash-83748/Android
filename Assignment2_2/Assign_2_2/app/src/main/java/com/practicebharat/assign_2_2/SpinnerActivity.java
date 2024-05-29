package com.practicebharat.assign_2_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    Spinner countriesSpinner,statesSpinner;
    List<String> countries;
    List<String> states;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        countriesSpinner=findViewById(R.id.countriesSpinner);
        statesSpinner=findViewById(R.id.statesSpinner);
        countries= new ArrayList<>();
        
        countries.add("India");
        countries.add("USA");
        countries.add("UK");
        countries.add("China");
        countries.add("Japan");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,countries);
        countriesSpinner.setAdapter(adapter);

        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(countries.get(i)=="India")
                {
                    states= new ArrayList<>();
                    states.add("Maharashtra");
                    states.add("Madhya Pradesh");
                    ArrayAdapter adapter2= new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_list_item_1,states);
                    statesSpinner.setAdapter(adapter2);
                }
                if(countries.get(i)=="USA")
                {
                    states=new ArrayList<>();
                    states.add("Wyoming");
                    states.add("Florida");
                    ArrayAdapter adapter2= new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_list_item_1,states);
                    statesSpinner.setAdapter(adapter2);
                }
                if(countries.get(i)=="UK")
                {
                    states=new ArrayList<>();
                    states.add("England");
                    states.add("Wales");
                    states.add("Scotland");
                    states.add("Northern Ireland");
                    ArrayAdapter adapter2= new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_list_item_1,states);
                    statesSpinner.setAdapter(adapter2);
                }

                if(countries.get(i)=="China")
                {
                    states=new ArrayList<>();
                    states.add("Hubei");
                    states.add("Anhui");
                    states.add("Yunan");
                    ArrayAdapter adapter2= new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_list_item_1,states);
                    statesSpinner.setAdapter(adapter2);
                }

                if(countries.get(i)=="Japan")
                {
                    states=new ArrayList<>();
                    states.add("Tohoku");
                    states.add("Tokyo");
                    states.add("Kinki");
                    ArrayAdapter adapter2= new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_list_item_1,states);
                    statesSpinner.setAdapter(adapter2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}