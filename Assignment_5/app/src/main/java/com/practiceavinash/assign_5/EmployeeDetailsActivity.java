package com.practiceavinash.assign_5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView textName, textDesignation;
    ImageView imageEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        textName = findViewById(R.id.textName);
        textDesignation = findViewById(R.id.textDesignation);
        imageEmployee = findViewById(R.id.imageEmployee);
        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        imageEmployee.setImageResource(employee.getImage());
        textName.setText("Name: "+employee.getName());
        textDesignation.setText("Designation :"+employee.getDesignation());
    }
}
