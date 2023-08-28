package edu.au.cpsc.modalwindows;

import edu.au.cpsc.modalwindows.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogEditorApplicationController {

  @FXML
  private Parent customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> showCustomerEditor(event.getSelectedCustomer()));
  }

  private void showCustomerEditor(Customer selectedCustomer) {
    Alert a = new Alert(AlertType.INFORMATION, selectedCustomer == null ? "no customer selected" : selectedCustomer.toString());
    a.showAndWait();
  }

}
