package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerDetailViewController {

  @FXML
  private TextField nameField, emailField, phoneNumberField;

  @FXML
  private Label validationErrorLabel;

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

  public boolean updateCustomer(Customer customer) {
    if (!validate()) return false;
    customer.setName(nameField.getText());
    customer.setEmail(emailField.getText());
    customer.setPhoneNumber(phoneNumberField.getText());
    return true;
  }

  private boolean validate() {
    boolean isValid = true;
    isValid = validateFieldNotEmpty(nameField);
    isValid = validateFieldNotEmpty(emailField) && isValid;
    isValid = validateFieldNotEmpty(phoneNumberField) && isValid;
    if (isValid) {
      validationErrorLabel.getStyleClass().add("hidden");
    } else {
      validationErrorLabel.getStyleClass().remove("hidden");
    }
    return isValid;
  }

  private boolean validateFieldNotEmpty(TextField field) {
    if (field.getText().trim().length() == 0) {
      field.getStyleClass().add("error");
      return false;
    } else {
      field.getStyleClass().remove("error");
    }
    return true;
  }

  @FXML
  protected void nameKeyTyped() {
    validateFieldNotEmpty(nameField);
  }

  @FXML
  protected void emailKeyTyped() {
    validateFieldNotEmpty(emailField);
  }

  @FXML
  protected void phoneNumberKeyTyped() {
    validateFieldNotEmpty(phoneNumberField);
  }

}
