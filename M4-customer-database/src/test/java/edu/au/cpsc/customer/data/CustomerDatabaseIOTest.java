package edu.au.cpsc.customer.data;

import static org.junit.jupiter.api.Assertions.*;

import edu.au.cpsc.customer.model.Customer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class CustomerDatabaseIOTest {

  @Test
  void givenDatabaseWithCustomersWhenSavedAndLoadedThenAllCustomersInCustomers()
      throws IOException, ClassNotFoundException {
    CustomerDatabase customerDatabase = new CustomerDatabase();
    Customer fred = new Customer("Fred", "fred@h.net", "724-555-1212");
    Customer barney = new Customer("Barney", "barney@h.net", "724-123-4567");
    customerDatabase.addCustomer(fred);
    customerDatabase.addCustomer(barney);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    CustomerDatabaseIO.save(customerDatabase, out);

    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    CustomerDatabase databaseFromStream = CustomerDatabaseIO.load(in);

    assertEquals(2, databaseFromStream.getCustomers().size());
  }

}