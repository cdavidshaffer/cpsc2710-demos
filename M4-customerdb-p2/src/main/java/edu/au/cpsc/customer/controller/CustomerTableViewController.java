package edu.au.cpsc.customer.controller;


import edu.au.cpsc.customer.model.Customer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
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
  private ObservableList<Customer> customerList;


  public void initialize() {
    nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
    customerTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
  }

  public void showCustomerList(List<Customer> customers) {
    customerList = FXCollections.observableList(customers);
    SortedList<Customer> sortedList = new SortedList<>(
        customerList);
    customerTableView.setItems(sortedList);
    sortedList.comparatorProperty().bind(customerTableView.comparatorProperty());
  }

  private void tableSelectionChanged() {
    Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();
    CustomerTableEvent event = new CustomerTableEvent(CustomerTableEvent.CUSTOMER_SELECTED,
        selectedCustomer);
    customerTableView.fireEvent(event);
  }

  public void updateTableContents() {
    customerTableView.refresh();
  }

  public static class CustomerTableEvent extends Event {

    public static final EventType<CustomerTableEvent> ANY = new EventType<>(Event.ANY, "ANY");

    public static final EventType<CustomerTableEvent> CUSTOMER_SELECTED = new EventType<>(ANY, "CUSTOMER_SELECTED");

    private final Customer selectedCustomer;

    public CustomerTableEvent(EventType<? extends Event> eventType, Customer selectedCustomer) {
      super(eventType);
      this.selectedCustomer = selectedCustomer;
    }

    public Customer getSelectedCustomer() {
      return selectedCustomer;
    }

  }

}

