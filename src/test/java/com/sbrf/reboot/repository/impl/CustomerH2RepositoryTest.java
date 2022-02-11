package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerH2RepositoryTest {

  private static CustomerRepository customerRepository;

  private static CustomerH2Repository customerH2Repository;

  @BeforeAll
  public static void before() {
    customerRepository = new CustomerH2Repository();
    if (customerRepository.getClass().equals(CustomerH2Repository.class)) {
      customerH2Repository = (CustomerH2Repository) customerRepository;
    }
  }

  @Test
  void getAll() {
    boolean tomCreated = customerRepository.createCustomer("Tom", "tom@ya.ru");

    List<Customer> all = customerRepository.getAll();

    assertTrue(all.size() != 0);
  }

  @Test
  void createCustomer() {

    boolean mariaCreated = customerRepository.createCustomer("Maria", "maria98@ya.ru");

    assertTrue(mariaCreated);
  }

  @Test
  void doesCustomerExistsTest(){
    customerH2Repository.clearTable();
    boolean mariaCreated = customerRepository.createCustomer("Maria", "maria98@ya.ru");
    boolean tomCreated = customerRepository.createCustomer("Tom", "tom@ya.ru");
    boolean mikeCreated = customerRepository.createCustomer("Mike", "mike@gmail.com");
    assertFalse(customerH2Repository.doesCustomerExist("John"));
    assertTrue(customerH2Repository.doesCustomerExist("Mike"));
  }

  @AfterAll
  public static void after() {

    System.out.println("connection is closed...");
    customerH2Repository.showTable();
    customerH2Repository.closeRepositoryAndDropTable();

  }
}