package edu.au.cpsc.decoupling;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerDetailViewController {

  @FXML
  private TextField nameField, emailField, phoneNumberField;

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
