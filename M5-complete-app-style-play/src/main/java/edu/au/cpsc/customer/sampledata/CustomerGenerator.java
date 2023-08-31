package edu.au.cpsc.customer.sampledata;

import edu.au.cpsc.customer.data.Db;
import edu.au.cpsc.customer.model.Customer;

public class CustomerGenerator {

  public static void main(String[] args) {
    Customer c1 = new Customer("Fred", "fred@bedrock.org", "555-1212");
    Customer c2 = new Customer("Wilma", "wilma@bedrock.org", "555-1234");
    Db.getDatabase().addCustomer(c1);
    Db.getDatabase().addCustomer(c2);
    Db.saveDatabase();
  }

}
