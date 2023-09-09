package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.data.Db;
import edu.au.cpsc.customer.model.Customer;
import edu.au.cpsc.customer.uimodel.CustomerDetailModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
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
  private Button updateButton, newButton, deleteButton;

  @FXML
  private MenuItem updateMenuItem, newMenuItem, deleteMenuItem;

  public void initialize() {
    customerTableViewController.showCustomers(Db.getDatabase().getCustomers());
    customerTableViewController.onCustomerSelectionChanged(
        event -> showCustomer(event.getSelectedCustomer()));
    CustomerDetailModel uiModel = customerDetailViewController.getModel();
    bindButtonMenuEnable(uiModel);
    bindButtonMenuLabel(uiModel);
    showCustomer(null);
  }

  private void bindButtonMenuLabel(CustomerDetailModel uiModel) {
    StringBinding labelProperty = Bindings.when(uiModel.newProperty()).then("Add").otherwise("Update");
    updateButton.textProperty().bind(labelProperty);
    updateMenuItem.textProperty().bind(labelProperty);
  }

  private void bindButtonMenuEnable(CustomerDetailModel uiModel) {
    updateButton.disableProperty().bind(uiModel.modifiedProperty().not());
    updateMenuItem.disableProperty().bind(uiModel.modifiedProperty().not());
    newButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
    newMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
    deleteButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
    deleteMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
  }

  private void showCustomer(Customer customer) {
    customerDetailViewController.showCustomer(customer);
  }

  @FXML
  protected void updateButtonAction() {
    if (customerDetailViewController.getModel().isNew()) {
      addCustomer();
    } else {
      updateCustomer();
    }
  }

  private void addCustomer() {
    Customer customer = new Customer("", "", "");
    if (!customerDetailViewController.updateCustomer(customer)) {
      return; // validation failed
    }
    Db.getDatabase().addCustomer(customer);
    saveDatabaseAndUpdateTable(customer);
  }

  private void updateCustomer() {
    Customer customer = getCustomerBeingEdited();
    if (!customerDetailViewController.updateCustomer(customer)) {
      return; // validation failed
    }
    Db.getDatabase().updateCustomer(customer);
    saveDatabaseAndUpdateTable(customer);
  }

  private void saveDatabaseAndUpdateTable(Customer customer) {
    Db.saveDatabase();
    customerTableViewController.showCustomers(Db.getDatabase().getCustomers());
    customerTableViewController.select(customer);
  }

  @FXML
  protected void newButtonAction() {
    customerTableViewController.select(null);
  }

  @FXML
  protected void deleteButtonAction() {
    if (customerDetailViewController.getModel().isNew()) {
      customerTableViewController.select(null);
    } else {
      Db.getDatabase().removeCustomer(getCustomerBeingEdited());
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
    choiceDialog.showAndWait().ifPresent(selection -> setTheme(selection));
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


  /**
   * Current customer being edited
   */
  public Customer getCustomerBeingEdited() {
    return customerTableViewController.getSelectedCustomer();
  }

}
