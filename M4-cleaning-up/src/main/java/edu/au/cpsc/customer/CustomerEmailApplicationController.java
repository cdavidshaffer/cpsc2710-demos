package edu.au.cpsc.customer;

import edu.au.cpsc.customer.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;

public class CustomerEmailApplicationController {

  @FXML
  private TableView<Customer> customerTableView;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> showCustomer(event.getSelectedCustomer()));
  }

  public void showCustomer(Customer selectedCustomer) {
    Alert alert = new Alert(AlertType.INFORMATION, selectedCustomer.toString());
    alert.showAndWait();
  }
}
