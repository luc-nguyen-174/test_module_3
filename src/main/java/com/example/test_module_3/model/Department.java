package com.example.test_module_3.model;

public class Department {
    private int department_id;
    private String department_name;

    public Department() {
    }

    public Department(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment() {
        return department_name;
    }

    public void setDepartment(String department_name) {
        this.department_name = department_name;
    }
}
