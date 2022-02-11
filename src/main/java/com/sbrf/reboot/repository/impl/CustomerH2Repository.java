package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.SchemaOutputResolver;

public class CustomerH2Repository implements CustomerRepository {

  private final String JDBC_DRIVER = "org.h2.Driver";
  private final String DB_URL = "jdbc:h2:~/my_db";

  private final String USER = "sa";
  private final String PASS = "";

  private final String DB_NAME = "CUSTOMER";
  private final String CREATE_TABLE_QUERY = "CREATE TABLE "
      + "IF NOT EXISTS "
      + "CUSTOMERS ("
      + "id BIGINT auto_increment PRIMARY KEY, "
      + "name VARCHAR(30), "
      + "eMail VARCHAR(30)"
      + ")";

  private final String INSERT_QUERY = "INSERT INTO CUSTOMERS (name, eMail) VALUES(?, ?)";

  private final String SELECT_QUERY = "SELECT id, name, eMail FROM CUSTOMERS";

  private final String DROP_QUERY = "DROP TABLE CUSTOMERS";

  private Connection conn;

  public CustomerH2Repository() {

    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stm = conn.createStatement();

      stm.executeUpdate(CREATE_TABLE_QUERY);
    } catch (SQLException sqle) {
      System.out.println(sqle.getMessage());
    }
  }

  @Override
  public List<Customer> getAll() {

    List<Customer> customers = new ArrayList<>();

    try (Statement stm = conn.createStatement()) {
      try (ResultSet resultSet = stm.executeQuery(SELECT_QUERY)) {
        while (resultSet.next()) {
          customers.add(new Customer(resultSet.getLong("id"), resultSet.getString("name"),
              resultSet.getString("eMail")));
        }
      }
    } catch (SQLException sqle) {
      System.out.println(sqle.getMessage());
    }

    return customers;
  }

  @Override
  public boolean createCustomer(String name, String eMail) {

    int res = 0;

    try (PreparedStatement pstm = conn.prepareStatement(INSERT_QUERY)) {
      pstm.setString(1, name);
      pstm.setString(2, eMail);
      res = pstm.executeUpdate();
      return true;
    } catch (SQLException sqle) {
      System.out.println(sqle.getMessage());
      return false;
    }
  }

  // Доп методы для работы с БД.

  public boolean closeRepositoryAndDropTable() {
    try (Statement stm = conn.createStatement()) {
      stm.executeUpdate(DROP_QUERY);
      conn.close();
      return true;
    } catch (SQLException e) {
      e.getMessage();
      return false;
    }
  }

  public boolean clearTable() {
    try (Statement stm = conn.createStatement()) {
      stm.executeUpdate("DELETE FROM CUSTOMERS");
      return true;
    } catch (SQLException sqle) {
      sqle.getMessage();
      return false;
    }
  }

  /**
   * Вывод содержания таблицы в консоль.
   */
  public void showTable() {
    try (Statement stm = conn.createStatement()) {
      try (ResultSet rs = stm.executeQuery(SELECT_QUERY)) {
        while (rs.next()) {
          System.out.println(rs.getLong("id") +
              " | " + rs.getString("name") +
              " | " + rs.getString("eMail"));
        }
      }
    } catch (SQLException e) {
      e.getMessage();
    }
  }

  /**
   * Проверка, что customer с заданным name существует.
   */
  public boolean doesCustomerExist(String name) {
    try (PreparedStatement pstmCount = conn.prepareStatement("SELECT COUNT(*) FROM CUSTOMERS WHERE name = ?")) {
      pstmCount.setString(1, name);
      try(ResultSet res = pstmCount.executeQuery()) {

        if (res.next() && res.getInt(1) != 0) {
          System.out.println("Кол-во записей с заданным именем : " + res.getInt(1));
          return true;
        } else {
          System.out.println("С заданным именем покупателя нет в таблице.");
          return false;
        }
      }
    } catch (SQLException e) {
      System.out.println("Something went wrong.");
      return false;
    }
  }
}


