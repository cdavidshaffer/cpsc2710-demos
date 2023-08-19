package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.controller.CustomerTableViewController.CustomerTableEvent;
import edu.au.cpsc.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class CustomerOverviewApplicationController {

  @FXML
  private TableView<Customer> customerTableView;

  @FXML
  private CustomerDetailViewController customerDetailViewController;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> customerDetailViewController.showCustomer(event.getSelectedCustomer()));
  }

}
