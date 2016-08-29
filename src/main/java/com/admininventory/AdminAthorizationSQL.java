/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admininventory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Dima
 */
public class AdminAthorizationSQL implements Serializable {

    private String url = "jdbc:mysql://localhost:3306/admin_inventory";
    private String userDB = "root";
    private String passwordDB = "root";

    public AdminAthorizationSQL() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserDB() {
        return userDB;
    }

    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

    public String getPasswordDB() {
        return passwordDB;
    }

    public void setPasswordDB(String passwordDB) {
        this.passwordDB = passwordDB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.url);
        hash = 11 * hash + Objects.hashCode(this.userDB);
        hash = 11 * hash + Objects.hashCode(this.passwordDB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdminAthorizationSQL other = (AdminAthorizationSQL) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.userDB, other.userDB)) {
            return false;
        }
        if (!Objects.equals(this.passwordDB, other.passwordDB)) {
            return false;
        }
        return true;
    }

    public boolean login(String login, String password) {
        boolean res = false;
        String passwordAdmin = null;
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDB, passwordDB);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password_admin FROM admin_data WHERE login_admin = ?");

            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                passwordAdmin = resultSet.getString("password_admin");

            }

            if (passwordAdmin != null && passwordAdmin.equals(password)) {
                res = true;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

}
