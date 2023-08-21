package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.CustomerOverviewApplication;
import edu.au.cpsc.customer.controller.CustomerTableViewController.CustomerTableEvent;
import edu.au.cpsc.customer.data.CustomerDatabase;
import edu.au.cpsc.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class CustomerOverviewApplicationController {

  @FXML
  private TableView<Customer> customerTableView;

  @FXML
  private CustomerTableViewController customerTableViewController;

  @FXML
  private CustomerDetailViewController customerDetailViewController;
  private boolean editingNewCustomer = true;
  private Customer customerBeingEdited = new Customer("", "", "");

  public void initialize() {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED,
        event -> editCustomer(event.getSelectedCustomer(), false));
    customerTableViewController.showCustomerList(getCustomerDatabase().getCustomers());
  }

  private void editCustomer(Customer customer, boolean isNew) {
    customerDetailViewController.showCustomer(customer);
    customerBeingEdited = customer;
    editingNewCustomer = isNew;
  }

  @FXML
  protected void newButtonAction() {
    editCustomer(new Customer("", "", ""), true);
  }

  @FXML
  protected void updateButtonAction() {
    customerDetailViewController.updateCustomer(customerBeingEdited);
    if (editingNewCustomer) {
      getCustomerDatabase().addCustomer(customerBeingEdited);
      editingNewCustomer = false;
    } else {
      getCustomerDatabase().updateCustomer(customerBeingEdited);
    }
    CustomerOverviewApplication.saveCustomerDatabase();
    customerTableViewController.updateTableContents();
  }

  private static CustomerDatabase getCustomerDatabase() {
    return CustomerOverviewApplication.getCustomerDatabase();
  }

  @FXML
  protected void deleteButtonAction() {
    if (editingNewCustomer) return;
    getCustomerDatabase().removeCustomer(customerBeingEdited);
    CustomerOverviewApplication.saveCustomerDatabase();
    editCustomer(customerBeingEdited, true);
    customerTableViewController.updateTableContents();
  }

  @FXML
  protected void updateMenuItemAction() {
    updateButtonAction();
  }

  @FXML
  protected void newMenuItemAction() {
    newButtonAction();
  }

  @FXML
  protected void deleteMenuItemAction() {
    deleteButtonAction();
  }

}
