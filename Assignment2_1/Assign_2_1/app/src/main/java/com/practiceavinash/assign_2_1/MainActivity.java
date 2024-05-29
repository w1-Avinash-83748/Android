package com.practiceavinash.assign_2_1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String tag ="MainActivity";
    EditText
            textFirstName,textSecondName,textEmail,textMobile;
    RadioButton
            btnMale,btnFemale;
    CheckBox
            boxVeg,boxNonVeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFirstName=findViewById(R.id.textFirstName);
        textSecondName=findViewById(R.id.textSecondName);
        textEmail=findViewById(R.id.textEmail);
        textMobile=findViewById(R.id.textMobile);
        btnMale=findViewById(R.id.btnMale);
        btnFemale=findViewById(R.id.btnFemale);
        boxVeg=findViewById(R.id.boxVeg);
        boxNonVeg=findViewById(R.id.boxNonVeg);
    }
    public void save(View view)
    {
        String firstName= textFirstName.getText().toString();
        String secondName= textSecondName.getText().toString();
        String email= textEmail.getText().toString();
        String mobile= textMobile.getText().toString();
        if(firstName.equals(""))
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show();
        else if(secondName.equals(""))
            Toast.makeText(this, "Enter Second name", Toast.LENGTH_SHORT).show();
        else if(email.equals(""))
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        else if (mobile.equals(""))
            Toast.makeText(this, "Enter Mobile", Toast.LENGTH_SHORT).show();

        String gender="";
        if(btnMale.isChecked())
            gender="Male";
        else if(btnFemale.isChecked())
            gender="Female";
        else
            Toast.makeText(this,"Please select gender",Toast.LENGTH_SHORT).show();

        List<String> foodList= new ArrayList<>();
        if(boxVeg.isChecked())
            foodList.add("Veg");
        if(boxNonVeg.isChecked())
            foodList.add("Non-Veg");
        else if(foodList.isEmpty())
            Toast.makeText(this, "Please select food", Toast.LENGTH_SHORT).show();

        if(firstName.isEmpty()||secondName.isEmpty()||email.isEmpty()||mobile.isEmpty()||gender.isEmpty()||foodList.isEmpty())
            Log.e(tag,"No value to insert");

        else {
            Intent intent = new Intent(this,DetailsActivity.class);
            intent.putExtra("FirstName",firstName);
            intent.putExtra("SecondName",secondName);
            intent.putExtra("Email",email);
            intent.putExtra("Mobile",mobile);
            intent.putExtra("Gender",gender);
            intent.putExtra("FoodList",foodList.toString());
            startActivity(intent);

        }

    }
}
