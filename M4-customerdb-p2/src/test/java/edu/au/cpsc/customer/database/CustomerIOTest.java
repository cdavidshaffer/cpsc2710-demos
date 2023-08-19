package edu.au.cpsc.customer.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.customer.data.CustomerDatabase;
import edu.au.cpsc.customer.data.CustomerDatabaseIO;
import edu.au.cpsc.customer.model.Customer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class CustomerIOTest {

  @Test
  public void givenDatabaseWhenSavedThenLoadedHasSameCustomers() throws IOException {
    CustomerDatabase cd = new CustomerDatabase();
    Customer pebbles = new Customer("Pebbles", "peb@bedrock.net", null);
    cd.addCustomer(pebbles);
    Customer bamBam = new Customer("BamBam", "bam-to-the-bam@bedrock.net", "555-4848");
    cd.addCustomer(bamBam);
    Customer dino = new Customer("Dino", "dino-the-dinosaur@bedrock.net", "555-9999");

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    CustomerDatabaseIO.save(cd, os);

    ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
    CustomerDatabase fromFile = CustomerDatabaseIO.load(is);

    assertEquals(fromFile.getCustomers().size(), 2);
    assertTrue(fromFile.getCustomers().contains(pebbles));
    assertTrue(fromFile.getCustomers().contains(bamBam));
    assertFalse(fromFile.getCustomers().contains(dino));

  }

}
