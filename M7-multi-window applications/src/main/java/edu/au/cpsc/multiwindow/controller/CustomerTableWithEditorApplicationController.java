package edu.au.cpsc.multiwindow.controller;

import edu.au.cpsc.multiwindow.controller.CustomerTableViewController.CustomerTableEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;

public class CustomerTableWithEditorApplicationController {

  @FXML
  private Parent customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private Parent customerDetailEditor;

  @FXML
  private CustomerDetailEditorController customerDetailEditorController;

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> customerDetailEditorController.showCustomer(event.getSelectedCustomer()));
  }


}
