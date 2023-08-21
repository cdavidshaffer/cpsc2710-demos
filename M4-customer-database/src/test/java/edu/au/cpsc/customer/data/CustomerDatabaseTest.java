package edu.au.cpsc.customer.data;

import static org.junit.jupiter.api.Assertions.*;

import edu.au.cpsc.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDatabaseTest {

  private CustomerDatabase customerDatabase;
  private Customer fred;
  private Customer barney;

  @BeforeEach
  void setUp() {
    customerDatabase = new CustomerDatabase();
    fred = new Customer("Fred", "fred@h.net", "724-555-1212");
    barney = new Customer("Barney", "barney@h.net", "724-123-4567");
  }

  @Test
  void givenNewDatabaseThenNoCustomers() {
    assertEquals(0, customerDatabase.getCustomers().size());
  }

  @Test
  void givenNewDatabaseWhenCustomerAddedThenOneCustomers() {
    // When
    customerDatabase.addCustomer(fred);
    // Then
    assertEquals(1, customerDatabase.getCustomers().size());
  }

  @Test
  void givenNewDatabaseWhenCustomerAddedThenCustomerInCustomers() {
    customerDatabase.addCustomer(fred);
    assertTrue(customerDatabase.getCustomers().contains(fred));
  }

  @Test
  void givenNewDatabaseWhenCustomerAddedThenDifferentCustomerNotInCustomers() {
    customerDatabase.addCustomer(fred);
    assertFalse(customerDatabase.getCustomers().contains(barney));
  }

  @Test
  void givenNewDatabaseWhenTwoCustomersAddedThenBothInCustomers() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(barney);

    assertTrue(customerDatabase.getCustomers().contains(fred));
    assertTrue(customerDatabase.getCustomers().contains(barney));
  }

  @Test
  void givenDatabaseWithTwoCustomersWhenCustomerRemovedThenNotInCustomers() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(barney);

    customerDatabase.removeCustomer(barney);

    assertFalse(customerDatabase.getCustomers().contains(barney));
  }

  @Test
  void givenDatabaseWithTwoCustomersWhenCustomerUpdatedThenModifiedCustomerInCustomers() {
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(barney);

    fred.setEmail("whatever@something.com");
    customerDatabase.updateCustomer(fred);

    Customer newFred = null;
    for(Customer c: customerDatabase.getCustomers()) {
      if (c.getName().equals("Fred"))
        newFred = c;
    }
    assertNotNull(newFred);
    assertEquals("whatever@something.com", newFred.getEmail());
  }

}