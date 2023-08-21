package edu.au.cpsc.customer;

import edu.au.cpsc.customer.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class CustomerTableApplicationController {

  @FXML
  private TableView<Customer> customerTableView;

  @FXML
  private CustomerDetailViewController customerDetailViewController;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> customerDetailViewController.showCustomer(event.getSelectedCustomer()));
  }

}
