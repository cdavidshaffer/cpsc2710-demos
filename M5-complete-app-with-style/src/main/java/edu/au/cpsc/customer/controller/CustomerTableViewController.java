package edu.au.cpsc.customer.controller;


import edu.au.cpsc.customer.model.Customer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerTableViewController  {

  @FXML
  private TableView<Customer> customerTableView;

  @FXML
  private TableColumn<Customer, String> nameColumn, emailColumn, phoneNumberColumn;


  public void initialize() {
    nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
    customerTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
  }

  public void showCustomers(List<Customer> customers) {
    SortedList<Customer> sortedList = new SortedList<>(FXCollections.observableList(customers));
    customerTableView.setItems(sortedList);
    sortedList.comparatorProperty().bind(customerTableView.comparatorProperty());
    customerTableView.refresh();
  }

  public void onCustomerSelectionChanged(EventHandler<CustomerTableEvent> handler) {
    customerTableView.addEventHandler(CustomerTableEvent.CUSTOMER_SELECTED, handler);
  }

  private void tableSelectionChanged() {
    Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
    CustomerTableEvent event = new CustomerTableEvent(CustomerTableEvent.CUSTOMER_SELECTED,
        selectedCustomer);
    customerTableView.fireEvent(event);
  }

  public void select(Customer customer) {
    customerTableView.getSelectionModel().select(customer);
  }

  public static class CustomerTableEvent extends Event {

    public static final EventType<CustomerTableEvent> ANY = new EventType<>(Event.ANY, "ANY");

    public static final EventType<CustomerTableEvent> CUSTOMER_SELECTED = new EventType<>(ANY, "CUSTOMER_SELECTED");

    private Customer selectedCustomer;

    public CustomerTableEvent(EventType<? extends Event> eventType, Customer selectedCustomer) {
      super(eventType);
      this.selectedCustomer = selectedCustomer;
    }

    public Customer getSelectedCustomer() {
      return selectedCustomer;
    }

  }

}

