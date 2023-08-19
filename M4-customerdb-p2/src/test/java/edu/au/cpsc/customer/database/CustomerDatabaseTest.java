package edu.au.cpsc.customer.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.customer.data.CustomerDatabase;
import edu.au.cpsc.customer.model.Customer;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDatabaseTest {

  private Customer fred, wilma, barney;

  private CustomerDatabase customerDatabase; // this is the Object Under Test

  @BeforeEach
  public void setUp() {
    fred = new Customer("Fred Flintstone", "fred@bedrock.org", "555-1212");
    barney = new Customer("Barney Rubble", "the-big-b@gmail.com", "555-9876");
    wilma = new Customer("Wilma Flintstone", "wilma@bedrock.org", "555-1234");
    customerDatabase = new CustomerDatabase();
  }

  @Test
  public void givenNewDatabaseThenNoCustomers() {
    assertEquals(customerDatabase.getCustomers().size(), 0);
  }

  @Test
  public void givenNewDatabaseWhenAddingCustomerThenCustomerInCustomersByEquality() {
    customerDatabase.addCustomer(fred);
    assertTrue(customerDatabase.getCustomers().contains(fred));
  }

  @Test
  public void givenNewDatabaseWhenAddingMultipleCustomersThenAllInCustomersByEquality() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(wilma);
    customerDatabase.addCustomer(barney);
    assertTrue(customerDatabase.getCustomers().contains(fred));
    assertTrue(customerDatabase.getCustomers().contains(wilma));
    assertTrue(customerDatabase.getCustomers().contains(barney));
  }

  @Test
  public void givenDatabaseWithOneCustomerWhenNotAddingAnotherCustomerThenAnotherCustomerNotInCustomers() {
    customerDatabase.addCustomer(fred);
    assertFalse(customerDatabase.getCustomers().contains(barney));
  }

  @Test
  public void givenDatabaseWithTwoCustomersWhenOneRemovedThenThatCustomerNotInCustomers() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(wilma);
    customerDatabase.removeCustomer(fred);
    assertFalse(customerDatabase.getCustomers().contains(fred));
  }

  @Test
  public void givenDatabaseWithTwoCustomersWhenOneUpdatedThenCustomersContainsUpdatedCustomer() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(wilma);
    fred.setEmail("newemail");
    customerDatabase.updateCustomer(fred);

    Customer fredFromDatabase = null;
    for(Customer c: customerDatabase.getCustomers())
      if (c.getName().equals("Fred Flintstone"))
        fredFromDatabase = c;
    assertEquals(fredFromDatabase.getEmail(), "newemail");
  }

  @Test
  public void givenDatabaseWithTwoCustomersWhenSearchByNameThenCorrectCustomerFound() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(wilma);
    List<Customer> cs = customerDatabase.customersWithName("Wilma Flintstone");
    assertEquals(cs.size(), 1);
    assertTrue(cs.contains(wilma));
  }

  @Test
  public void givenDatabaseWithTwoCustomersWhenSearchByNameForNonexistentThenNoCustomerFound() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(wilma);
    List<Customer> cs = customerDatabase.customersWithName("Mr. Slate");
    assertTrue(cs.isEmpty());
  }

}
