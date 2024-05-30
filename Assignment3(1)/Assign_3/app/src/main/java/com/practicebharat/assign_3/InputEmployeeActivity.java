package com.practicebharat.assign_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputEmployeeActivity extends AppCompatActivity {

    EditText editEmpno,editName,editSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_employee);
        editEmpno=findViewById(R.id.editEmpno);
        editName=findViewById(R.id.editName);
        editSalary=findViewById(R.id.editSalary);
    }
    public void save(View view){
        Employee employee= new Employee();
        employee.setEmpno(Integer.parseInt(editEmpno.getText().toString()));
        employee.setName(editName.getText().toString());
        employee.setSalary(Double.parseDouble(editSalary.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("employee",employee);
        setResult(0,intent);
        finish();

    }
}