package edu.au.cpsc.menus;

import edu.au.cpsc.menus.CustomerTableViewController.CustomerTableEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class CustomerSummaryApplicationController {

  @FXML
  private Parent customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private Parent customerDetailEditor;

  @FXML
  private CustomerDetailEditorController customerDetailEditorController;

  public void initialize() {
    // Connect our two views together.  When the table view fires a CUSTOMER_SELECTED event,
    // we tell the detail view to show that customer.
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> customerDetailEditorController.showCustomer(event.getSelectedCustomer()));
  }

  @FXML
  protected void menuCloseAction() {
    // Preferred way to shut down a JavaFX application
    Platform.exit();
    // You could just use:
    //    System.exit(0);
    // but then the Application's stop() method will not get to run.
  }

  @FXML
  protected void menuDeleteAction() {
    Alert confirmation = new Alert(AlertType.CONFIRMATION, "Delete this Customer?", ButtonType.NO, ButtonType.YES);
    confirmation.setTitle("Delete selected customer?");
    confirmation.showAndWait().ifPresent(buttonType -> {
      if (buttonType == ButtonType.YES)
        customerTableViewController.deleteSelectedCustomer();
    });
  }
  @FXML
  protected void menuAboutAction() {

  }

}
