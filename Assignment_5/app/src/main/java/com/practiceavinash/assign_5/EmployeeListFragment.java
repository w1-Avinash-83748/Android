package com.practiceavinash.assign_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListFragment extends Fragment {

RecyclerView recyclerView;
List<Employee> employeeList;
EmployeeListAdapter employeeListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeList=new ArrayList<>();
        employeeList.add(new Employee(R.drawable.billclinton,"Bill clinton","Ceo"));
        employeeList.add(new Employee(R.drawable.georgebush,"George Bush","MD"));
        employeeList.add(new Employee(R.drawable.ronalreagan,"Ronald Reagan","Business Head"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.listEmployee);
    employeeListAdapter= new EmployeeListAdapter(getContext(),employeeList);
    recyclerView.setAdapter(employeeListAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
    }
}
