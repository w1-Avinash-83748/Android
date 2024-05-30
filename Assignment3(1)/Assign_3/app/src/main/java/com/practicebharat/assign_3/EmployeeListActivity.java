package com.practicebharat.assign_3;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<Employee> employeeList;

    ArrayAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        toolbar=findViewById(R.id.toolbar);
        listview = findViewById(R.id.listView);
        setSupportActionBar(toolbar);
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Bharat",100000.0));
        employeeList.add(new Employee(2,"Nikhil",100000.0));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,employeeList);
        listview.setAdapter(adapter);

        //listview.setOnItemClickListener(toolbar);

    }
    ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            Intent intent = o.getData();
            Employee employee= (Employee) intent.getSerializableExtra("employee");
            employeeList.add(employee);
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(this,InputEmployeeActivity.class);
        activityResultLauncher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}