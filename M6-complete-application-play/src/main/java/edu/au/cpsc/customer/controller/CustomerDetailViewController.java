package edu.au.cpsc.customer.controller;

import edu.au.cpsc.customer.model.Customer;
import edu.au.cpsc.customer.uimodel.CustomerDetailModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerDetailViewController {

  @FXML
  private TextField nameField, emailField, phoneNumberField;

  @FXML
  private Label validationErrorLabel;

  private CustomerDetailModel model;

  public void initialize() {
    model = new CustomerDetailModel();
    nameField.textProperty().bindBidirectional(model.nameProperty());
    emailField.textProperty().bindBidirectional(model.emailProperty());
    phoneNumberField.textProperty().bindBidirectional(model.phoneNumberProperty());
  }

  public void showCustomer(Customer customer) {
    if (customer == null) {
      model.setName("");
      model.setEmail("");
      model.setPhoneNumber("");
      model.setNew(true);
      model.setModified(false);
      return;
    }
    model.setName(customer.getName());
    model.setEmail(customer.getEmail());
    model.setPhoneNumber(customer.getPhoneNumber());
    model.setNew(false);
    model.setModified(false);
  }

  public boolean updateCustomer(Customer customer) {
    if (!validate()) return false;
    customer.setName(model.getName());
    customer.setEmail(model.getEmail());
    customer.setPhoneNumber(model.getPhoneNumber());
    return true;
  }

  public CustomerDetailModel getModel() { return model; }

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
