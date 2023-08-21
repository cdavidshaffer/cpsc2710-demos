package edu.au.cpsc.customer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerDetailViewController {

  @FXML
  private TextField nameField, emailField, phoneNumberField;

  public void showCustomer(Customer customer) {
    if (customer == null) {
      nameField.clear();
      emailField.clear();
      phoneNumberField.clear();
      return;
    }
    nameField.setText(customer.getName());
    emailField.setText(customer.getEmail());
    phoneNumberField.setText(customer.getPhoneNumber());
  }

  public void updateCustomer(Customer customer) {
    customer.setName(nameField.getText());
    customer.setEmail(emailField.getText());
    customer.setPhoneNumber(phoneNumberField.getText());
  }

}
