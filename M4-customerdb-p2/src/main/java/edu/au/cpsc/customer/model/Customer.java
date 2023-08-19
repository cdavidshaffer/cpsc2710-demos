package edu.au.cpsc.customer.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Customer implements Serializable {

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Customer customer = (Customer) o;

    if (!Objects.equals(name, customer.name)) {
      return false;
    }
    if (!Objects.equals(email, customer.email)) {
      return false;
    }
    return Objects.equals(phoneNumber, customer.phoneNumber);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    return result;
  }
}
