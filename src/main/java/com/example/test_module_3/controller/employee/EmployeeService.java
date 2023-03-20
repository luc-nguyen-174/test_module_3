package com.example.test_module_3.controller.employee;

import com.example.test_module_3.controller.department.DepartmentService;
import com.example.test_module_3.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static com.example.test_module_3.connection.ConnectionDB.getConnection;

public class EmployeeService implements IEmployee {
    DepartmentService departmentService = new DepartmentService();

    @Override
    public List<EmployeeService> findAll() {
        List<EmployeeService> employees = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT * FROM employee");
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                double salary = rs.getDouble(6);


                int department_id = rs.getInt(7);
                Department department =departmentService.findById(department_id);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(EmployeeService generic) {

    }

    @Override
    public EmployeeService findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, EmployeeService generic) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
