package edu.au.cpsc.tableviewdemo;


import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerTableViewController  {

  @FXML
  private TextField nameField, phoneNumberField, emailField;

  @FXML
  private TableView<Customer> customerTableView;

  @FXML
  private TableColumn<Customer, String> nameColumn, emailColumn, phoneNumberColumn;


  public void initialize() {
    nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
    SortedList<Customer> sortedList = new SortedList<>(
        FXCollections.observableList(Customer.demoCustomers()));
    customerTableView.setItems(sortedList);
    sortedList.comparatorProperty().bind(customerTableView.comparatorProperty());
    customerTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
  }

  private void tableSelectionChanged() {
    Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
    if (selectedCustomer == null) {
      nameField.clear();
      emailField.clear();
      phoneNumberField.clear();
      return;
    }
    nameField.setText(selectedCustomer.getName());
    emailField.setText(selectedCustomer.getEmail());
    phoneNumberField.setText(selectedCustomer.getPhoneNumber());
  }
}

