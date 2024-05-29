package com.practiceavinash.assign_2_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
TextView
    firstName,secondName,email,mobile,foodList,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
      firstName=findViewById(R.id.firstName);
      secondName=findViewById(R.id.secondName);
      email= findViewById(R.id.email);
        mobile= findViewById(R.id.mobile);
        gender= findViewById(R.id.gender);
        foodList=findViewById(R.id.foodList);
        Intent intent = getIntent();
        firstName.setText(intent.getStringExtra("FirstName"));
        secondName.setText(intent.getStringExtra("SecondName"));
        email.setText(intent.getStringExtra("Email"));
        mobile.setText(intent.getStringExtra("Mobile"));
        gender.setText(intent.getStringExtra("Gender"));
        foodList.setText(intent.getStringExtra("FoodList"));



    }
}
