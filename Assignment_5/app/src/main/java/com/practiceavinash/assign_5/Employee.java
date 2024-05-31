package com.practiceavinash.assign_5;

import java.io.Serializable;

public class Employee implements Serializable
    {
    private int image;
    private String name;
    private String designation;

        public Employee(int image, String name, String designation) {
            this.image = image;
            this.name = name;
            this.designation = designation;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "image=" + image +
                    ", name='" + name + '\'' +
                    ", designation='" + designation + '\'' +
                    '}';
        }
    }
