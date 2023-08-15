package edu.au.cpsc.customer;

import java.util.List;

public class Customer {

  public static List<Customer> demoCustomers() {
    return List.of(new Customer("Fred", "fred@bedrock.org", "555-1212"),
        new Customer("Wilma", "wilma@bedrock.org", "555-1234"),
        new Customer("Barney", "the-big-b@gmail.com", "555-9876"));
  }

  private String name;
  private String email;
  private String phoneNumber;

  public Customer(String name, String email, String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
