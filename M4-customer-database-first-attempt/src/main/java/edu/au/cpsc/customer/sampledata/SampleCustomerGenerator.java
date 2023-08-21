package edu.au.cpsc.customer.sampledata;

import edu.au.cpsc.customer.CustomerSummaryApplication;
import edu.au.cpsc.customer.data.CustomerDatabase;
import edu.au.cpsc.customer.data.DatabaseManager;
import edu.au.cpsc.customer.model.Customer;

public class SampleCustomerGenerator {

  public static void main(String[] args) {
    CustomerDatabase cd = DatabaseManager.getCustomerDatabase();
    cd.addCustomer(new Customer("Eddie", "eddie@jam.com", "724-555-1221"));
    cd.addCustomer(new Customer("Mike", "mike@jam.com", "724-123-4567"));
    DatabaseManager.saveCustomerDatabase();
  }

}
