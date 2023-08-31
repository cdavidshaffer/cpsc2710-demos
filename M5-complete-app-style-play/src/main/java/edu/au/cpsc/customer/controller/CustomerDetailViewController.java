package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerDetailViewController {

  @FXML
  private Label errorLabel;

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
    validateFields();
  }

  public boolean updateCustomer(Customer customer) {
    if (!validateFields()) return false;
    customer.setName(nameField.getText());
    customer.setEmail(emailField.getText());
    customer.setPhoneNumber(phoneNumberField.getText());
    return true;
  }

  private boolean validateFields() {
    boolean success = validateNotNullOrBlank(nameField);
    success = validateNotNullOrBlank(emailField) && success;
    success = validateNotNullOrBlank(phoneNumberField) && success;
    if (!success)
      hideErrorLabel();
    else
      showErrorLabel();
    return success;
  }

  private void showErrorLabel() {
    errorLabel.getStyleClass().add("hidden");
  }

  private void hideErrorLabel() {
    errorLabel.getStyleClass().remove("hidden");
  }

  private boolean validateNotNullOrBlank(TextField field) {
    if (nullOrBlank(field.getText())) {
      field.getStyleClass().add("error");
      return false;
    } else {
      field.getStyleClass().remove("error");
      return true;
    }
  }

  private boolean nullOrBlank(String text) {
    return text == null || text.length() == 0;
  }

  @FXML
  protected void nameFieldKeyTyped() {
    nameField.getStyleClass().remove("error");
  }

  @FXML
  protected void emailFieldKeyTyped() {
    emailField.getStyleClass().remove("error");
  }

  @FXML
  protected void phoneNumberFieldKeyTyped() {
    phoneNumberField.getStyleClass().remove("error");
  }
}
