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

  public void addCustomer(Customer c) {
    customers.add(c);
  }

  public void removeCustomer(Customer c) {
    customers.remove(c);
  }

  public void updateCustomer(Customer c) {
    // Do nothing!!!!
    //
    // This method may seem strange but ,for an in-memory database, the Customer object has already
    // been modified and our List holds a reference to this modified object.  There's nothing to
    // "update."  In a relational database we'd send out a SQL UPDATE command here.
    //
    // This points to a significant problem when using this in-memory database as a temporary
    // stand-in for a real database.  You might find places where you forgot to call
    // updateCustomer() because it was unnecessary.  We /can/ make this in-memory database
    // act more like a real database but it isn't worth the work in this course.  If you're curious
    // about it, ask in Canvas Discussions and I'll follow-up.
  }

  // searching methods

  public List<Customer> customersWithName(String name) {
    ArrayList<Customer> result = new ArrayList<>();
    for(Customer c: getCustomers())
      if (c.getName().equals(name)) result.add(c);
    return result;
  }

}
