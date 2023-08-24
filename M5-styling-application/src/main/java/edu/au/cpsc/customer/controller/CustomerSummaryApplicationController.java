package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.data.Db;
import edu.au.cpsc.customer.model.Customer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class CustomerSummaryApplicationController {

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private CustomerDetailViewController customerDetailViewController;

  @FXML
  private Button updateButton;

  @FXML
  private MenuItem updateMenuItem;

  /**
   * Current customer being edited
   */
  private Customer customerBeingEdited;

  /**
   * Indicates whether the customer being edited is new or not
   */
  private boolean customerBeingEditedIsNew;

  public void initialize() {
    customerTableViewController.showCustomers(Db.getDatabase().getCustomers());
    customerTableViewController.onCustomerSelectionChanged(
        event -> showCustomer(event.getSelectedCustomer()));
    showCustomer(null);
  }

  private void showCustomer(Customer customer) {
    customerDetailViewController.showCustomer(customer);
    customerBeingEdited = customer == null ? new Customer("", "", "") : customer;
    customerBeingEditedIsNew = customer == null;
    String buttonLabel = customerBeingEditedIsNew ? "Add" : "Update";
    updateButton.setText(buttonLabel);
    updateMenuItem.setText(buttonLabel);
  }

  @FXML
  protected void updateButtonAction() {
    customerDetailViewController.updateCustomer(customerBeingEdited);
    if (customerBeingEditedIsNew) {
      Db.getDatabase().addCustomer(customerBeingEdited);
    } else {
      Db.getDatabase().updateCustomer(customerBeingEdited);
    }
    Db.saveDatabase();
    customerTableViewController.showCustomers(Db.getDatabase().getCustomers());
    customerTableViewController.select(customerBeingEdited);
  }

  @FXML
  protected void newButtonAction() {
    customerTableViewController.select(null);
  }

  @FXML
  protected void deleteButtonAction() {
    if (customerBeingEditedIsNew) {
      customerTableViewController.select(null);
    } else {
      Db.getDatabase().removeCustomer(customerBeingEdited);
      Db.saveDatabase();
      customerTableViewController.showCustomers(Db.getDatabase().getCustomers());
    }
  }

  @FXML
  protected void updateMenuAction() {
    updateButtonAction();
  }

  @FXML
  protected void newMenuAction() {
    newButtonAction();
  }

  @FXML
  protected void deleteMenuAction() {
    deleteButtonAction();
  }

  @FXML
  protected void closeMenuAction() {
    Platform.exit();
  }


}
