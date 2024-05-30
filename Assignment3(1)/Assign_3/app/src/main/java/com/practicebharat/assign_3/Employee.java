package com.practicebharat.assign_3;

import java.io.Serializable;

public class Employee implements Serializable {
    int empno;
    String name;
    double salary;

    public Employee(){

    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int empno, String name, double salary) {
        this.empno = empno;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return empno+" - "+name;
    }
}
