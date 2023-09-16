package edu.au.cpsc.multiwindow.controller;

import edu.au.cpsc.multiwindow.model.Customer;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CustomerTableWithButtonsApplicationController {

  /**
   * Display this window as a non-modal, non-blocking window.
   * <p>
   * This is support for my preferred approach to opening other windows.  Ie "Option 2".  I prefer this
   * because the code that loads the window is in the controller that will be responsible for
   * handling its events.
   * </p>
   * @throws IOException if FXML fails to load
   */
  public static void show() throws IOException {
    Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerTableWithEditorApplicationController.class.getResource(
        "/windows/customer-table-wth-buttons-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Table");
    stage.setScene(scene);
    stage.show();
  }

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
    // you get the idea :)
  }

  private void showNoCustomerSelectedAlert() {
    Alert a = new Alert(AlertType.WARNING, "No customer selected");
    a.showAndWait();
  }

  private void showCustomerEditor(Customer selectedCustomer) throws IOException {
    CustomerEditorDialogController controller = CustomerEditorDialogController.showModal(selectedCustomer,
        customerTableView.getScene().getWindow());
  }


}
