package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.data.Db;
import edu.au.cpsc.customer.model.Customer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.MenuItem;

public class CustomerSummaryApplicationController {

  @FXML
  private Parent applicationRoot;

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
    if (!customerDetailViewController.updateCustomer(customerBeingEdited))
      return; // validation failed
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

  @FXML
  protected void appearanceMenuAction() {
    ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Light", "Dark", "Light");
    choiceDialog.showAndWait().ifPresent( selection -> setTheme(selection));
  }

  private void setTheme(String selection) {
    String darkThemeUrl = getClass().getResource("/edu/au/cpsc/customer/style/dark.css")
        .toExternalForm();
    String lightThemeUrl = getClass().getResource("/edu/au/cpsc/customer/style/light.css")
        .toExternalForm();
    if (selection.equals("Dark")) {
      applicationRoot.getStylesheets().add(darkThemeUrl);
      applicationRoot.getStylesheets().remove(lightThemeUrl);
    } else {
      applicationRoot.getStylesheets().add(lightThemeUrl);
      applicationRoot.getStylesheets().remove(darkThemeUrl);
    }
  }


}
