package com.example.test_module_3.controller.employee;

import com.example.test_module_3.controller.department.DepartmentService;
import com.example.test_module_3.model.Department;
import com.example.test_module_3.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.test_module_3.connection.ConnectionDB.getConnection;

public class EmployeeService implements IEmployee {
    DepartmentService departmentService = new DepartmentService();

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
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
                Department department = departmentService.findById(department_id);

                employees.add(new Employee(id, name, email, address, phone, salary, department));
            }
            connection.commit();
        } catch (SQLException e) {
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
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public void save(Employee employee) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("INSERT INTO employee (name, email, address, phone, salary, department_id) values (?,?,?,?,?,?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getDepartment_id());
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");
            rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                double salary = rs.getDouble("salary");

                int department_id = Integer.parseInt(rs.getString("department_id"));
                Department department = departmentService.findById(department_id);
                employee = new Employee(id, name, email, address, phone, salary, department);
            }
            connection.commit();
        } catch (SQLException e) {
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
        return employee;
    }

    @Override
    public boolean update(int id, Employee employee) {
        boolean rowUpdated = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("update employee set name = ?, email = ?, address = ?, phone = ?, salary = ?, department_id = ? where id = ?;");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getDepartment_id());
            statement.setInt(7, id);
            rowUpdated = statement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM employee where id = ?")) {
            prepareStatement.setInt(1, id);
            rowDeleted = prepareStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;

    }


}
