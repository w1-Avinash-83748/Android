package com.practiceavinash.assign_5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    Context context;
    List<Employee> employeeList;

    public EmployeeListAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_employee,null);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.textName.setText(employeeList.get(position).getName());
        holder.textDesignation.setText(employeeList.get(position).getDesignation());
        holder.imageEmployee.setImageResource(employeeList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textName,textDesignation;
        ImageView imageEmployee;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageEmployee=itemView.findViewById(R.id.imageEmployee);
            textName=itemView.findViewById(R.id.textName);
            textDesignation=itemView.findViewById(R.id.textDesignation);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
        Intent intent = new Intent(context, EmployeeDetailsActivity.class);
        intent.putExtra("employee",employeeList.get(getAdapterPosition()));
        context.startActivity(intent);
        }
    }
}
