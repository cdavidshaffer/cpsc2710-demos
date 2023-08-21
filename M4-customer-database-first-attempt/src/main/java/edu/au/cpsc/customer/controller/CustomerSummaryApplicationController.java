package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.data.DatabaseManager;
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


  private boolean editingExistingCustomer;
  private Customer customerBeingEdited;

  public void initialize() {
    customerTableViewController.showCustomers(DatabaseManager.getCustomerDatabase().getCustomers());
    showCustomer(null);
    customerTableViewController.onCustomerSelected(
        event -> showCustomer(event.getSelectedCustomer()));
  }

  private void showCustomer(Customer customer) {
    customerDetailViewController.showCustomer(customer);
    editingExistingCustomer = customer != null;
    customerBeingEdited = customer == null ? new Customer("", "", "") : customer;
    String buttonText = editingExistingCustomer ? "Update" : "Add";
    updateButton.setText(buttonText);
    updateMenuItem.setText(buttonText);
  }

  @FXML
  protected void updateButtonAction() {
    customerDetailViewController.updateCustomer(customerBeingEdited);
    if (editingExistingCustomer) {
      DatabaseManager.getCustomerDatabase().updateCustomer(customerBeingEdited);
      customerTableViewController.refresh();
    } else {
      DatabaseManager.getCustomerDatabase().addCustomer(customerBeingEdited);
      customerTableViewController.addCustomer(customerBeingEdited);
    }
    DatabaseManager.saveCustomerDatabase();
  }

  @FXML
  protected void newButtonAction() {
    customerTableViewController.clearSelection();
    // uses the table selection handler to switch to empty customer (see showCustomer());
  }

  @FXML
  protected void deleteButtonAction() {
    DatabaseManager.getCustomerDatabase().removeCustomer(customerBeingEdited);
    DatabaseManager.saveCustomerDatabase();
    customerTableViewController.removeCustomer(customerBeingEdited);
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
