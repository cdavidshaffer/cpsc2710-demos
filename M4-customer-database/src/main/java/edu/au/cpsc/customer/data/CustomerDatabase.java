package edu.au.cpsc.customer.data;

import edu.au.cpsc.customer.model.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase implements Serializable {

  private List<Customer> customers;

  public CustomerDatabase() {
    customers = new ArrayList<>();
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  public void removeCustomer(Customer customer) {
    customers.remove(customer);
  }

  public void updateCustomer(Customer customer) {
    // nothing to do
    // we already reference the updated object
    //
    // if this was a relational database, we'd execute a SQL UPDATE
  }
}
