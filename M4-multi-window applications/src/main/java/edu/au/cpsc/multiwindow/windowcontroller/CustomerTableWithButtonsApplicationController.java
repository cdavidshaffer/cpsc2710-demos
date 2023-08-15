package edu.au.cpsc.multiwindow.windowcontroller;

import edu.au.cpsc.multiwindow.model.Customer;
import edu.au.cpsc.multiwindow.viewcontroller.CustomerTableViewController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CustomerTableWithButtonsApplicationController {

  @FXML
  private Parent customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private void editButtonAction() throws IOException {
    Customer selectedCustomer = customerTableViewController.getSelectedCustomer();
    if (selectedCustomer == null)
      showNoCustomerSelectedAlert();
    else
      showCustomerEditor(selectedCustomer);
  }

  @FXML
  private void deleteButtonAction() {

  }

  private void showNoCustomerSelectedAlert() {
    Alert a = new Alert(AlertType.WARNING, "No customer selected");
    a.showAndWait();
  }

  private void showCustomerEditor(Customer selectedCustomer) throws IOException {
    CustomerEditorDialogController controller = CustomerEditorDialogController.showModal(selectedCustomer);
  }


}
