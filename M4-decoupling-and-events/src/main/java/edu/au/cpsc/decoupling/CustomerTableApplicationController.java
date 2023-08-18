package edu.au.cpsc.decoupling;

import edu.au.cpsc.decoupling.CustomerTableViewController.CustomerTableEvent;
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
