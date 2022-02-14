package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/test";

    private final String USER = "sa";
    private final String PASS = "";

    private Connection conn;

    @SneakyThrows
    private Connection getConnection() {
        Class.forName(JDBC_DRIVER); //Проверяем наличие JDBC драйвера для работы с БД
        return conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customer;";
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {

                customers.add(new Customer());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean customerIsExist(@NonNull String userName) {

        String query = "SELECT name FROM Customer"
                + " WHERE name = " + "'" + userName +"';";
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet set = stmt.executeQuery(query);
            if (set.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {

        String query = "INSERT INTO Customer (name,eMail) VALUES (" + "'" + name + "'" + " ," + "'" + eMail + "'" + ");";

        try {
            Statement stmt = getConnection().createStatement();
            int rows = stmt.executeUpdate(query);
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}


