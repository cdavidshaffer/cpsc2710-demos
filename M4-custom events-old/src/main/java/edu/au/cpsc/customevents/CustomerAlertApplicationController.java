package edu.au.cpsc.customevents;

import edu.au.cpsc.customevents.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CustomerAlertApplicationController {

  @FXML
  private Parent customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> showCustomerAlert(event.getSelectedCustomer()));
  }

  private void showCustomerAlert(Customer selectedCustomer) {
    Alert a = new Alert(AlertType.INFORMATION, selectedCustomer == null ? "no customer selected" : selectedCustomer.toString());
    a.showAndWait();
  }

}
