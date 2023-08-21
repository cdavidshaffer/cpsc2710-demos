package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.model.Customer;
import javafx.fxml.FXML;

public class CustomerSummaryApplicationController {

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private CustomerDetailViewController customerDetailViewController;

  public void initialize() {
    customerTableViewController.showCustomers(Customer.demoCustomers());
    customerTableViewController.onCustomerSelectionChanged(
        event -> customerDetailViewController.showCustomer(event.getSelectedCustomer()));
  }

}
