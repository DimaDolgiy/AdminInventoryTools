/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admininventory.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admininventory.model.Employee;
import java.sql.PreparedStatement;

/**
 *
 * @author Dima
 */
@WebServlet(name = "ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {

    private List<Employee> employeeList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String className = "com.mysql.jdbc.Driver";
        String nameDataBase = "admin_inventory";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String name = "root";
        String password = "root";

        Connection connection;

        try {
            Class.forName(className);
            url += nameDataBase;

            connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            String selectEmployee = "SELECT * FROM employee";

            ResultSet resultSet = statement.executeQuery(selectEmployee);

            employeeList = new ArrayList<Employee>();

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setUserId(Integer.parseInt(resultSet.getString("user_id")));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setSecondName(resultSet.getString("secondName"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setJobPosition(resultSet.getString("jobPosition"));
                employee.setStartDate(resultSet.getString("startDate"));
                employee.setFiredDate(resultSet.getString("firedDate"));
                employeeList.add(employee);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("employeeList", employeeList);

        request.getRequestDispatcher("employee-list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String lastName = request.getParameter("lastName");
        String jobPosition = request.getParameter("jobPosition");
        String startDate = request.getParameter("startDate");
        String firedDate = request.getParameter("firedDate");
        
        

        if (request.getParameter("insert") != null) {

            String className = "com.mysql.jdbc.Driver";
            String nameDataBase = "admin_inventory";
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String name = "root";
            String password = "root";

            Connection connection;
            Statement statement;

            try {
                Class.forName(className);
                url += nameDataBase;

                connection = DriverManager.getConnection(url, name, password);
                statement = connection.createStatement();

                String insertEmp = "INSERT INTO employee (firstName, secondName, lastName, jobPosition, startDate, firedDate) VALUES ('" + firstName + "', '" + secondName + "', "
                        + "'" + lastName + "','" + jobPosition + "', '" + startDate + "', '" + firedDate + "');";
                statement.executeUpdate(insertEmp);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("view");

        }
        
        if (request.getParameter("delete") != null) {
            int empId = Integer.parseInt(request.getParameter("userId"));
 
            
            String className = "com.mysql.jdbc.Driver";
            String nameDataBase = "admin_inventory";
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String name = "root";
            String password = "root";

            Connection connection;
            PreparedStatement preparedStatement;
            try{
                
            Class.forName(className);
            url += nameDataBase;
            connection = DriverManager.getConnection(url, name, password);
                
            preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE user_id = ?");
            
            preparedStatement.setInt(1, empId);
            preparedStatement.executeUpdate();
            
            
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("view");
        
        
            
        }

    }
}


