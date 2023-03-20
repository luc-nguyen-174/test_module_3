package com.example.test_module_3.controller.department;

import com.example.test_module_3.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.test_module_3.connection.ConnectionDB.getConnection;

public class DepartmentService implements IDepartment {


    public static final String SELECT_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id = ?";

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT * FROM department");
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String department = rs.getString("department");
                departmentList.add(new Department(id, department));
            }
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return departmentList;
    }

    @Override
    public void save(Department generic) {

    }

    @Override
    public Department findById(int id) {
        Department department = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                String department_name = rs.getString("department");
                department = new Department(id, department_name);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return department;
    }

    @Override
    public boolean update(int id, Department generic) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
