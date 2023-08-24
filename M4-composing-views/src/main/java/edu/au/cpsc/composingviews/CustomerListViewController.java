package edu.au.cpsc.composingviews;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CustomerListViewController {

  @FXML
  private ListView<Customer> personList;

  @FXML
  private CustomerDetailViewController customerDetailViewController;


  public void initialize() {
    personList.setItems(FXCollections.observableList(Customer.demoCustomers()));
    personList.getSelectionModel().selectedItemProperty()
        .addListener(event -> listSelectionChanged());
    personList.setCellFactory(theListView -> new CustomerNameCell());
  }

  private void listSelectionChanged() {
    Customer selectedCustomer = personList.getSelectionModel().getSelectedItem();
    customerDetailViewController.showCustomer(selectedCustomer);
  }

  static class CustomerNameCell extends ListCell<Customer> {

    @Override
    protected void updateItem(Customer item, boolean empty) {
      // You must do this!!!
      super.updateItem(item, empty);

      if (empty || item == null) {
        setText(null);
        setGraphic(null);
      } else {
        setText(item.getName());
        if (item.getEmail().endsWith(".com"))
          setTextFill(Color.RED);
      }
    }
  }
}