package edu.au.cpsc.customevents;

import edu.au.cpsc.customevents.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;

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


}
