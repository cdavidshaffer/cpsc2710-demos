package edu.au.cpsc.customer;

import edu.au.cpsc.customer.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerDetailEditorController {

  @FXML
  private TextField nameField, phoneNumberField, emailField;

  public void showCustomer(Customer selectedCustomer) {
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
