package com.example.test_module_3.model;

public class Department {
    private int department_id;
    private String department;

    public Department() {
    }

    public Department(int department_id, String department) {
        this.department_id = department_id;
        this.department = department;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
