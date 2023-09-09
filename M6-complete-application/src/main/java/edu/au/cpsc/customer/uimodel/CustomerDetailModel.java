package edu.au.cpsc.customer.uimodel;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDetailModel {

  private final StringProperty nameProperty;
  private final StringProperty emailProperty;
  private final StringProperty phoneNumberProperty;
  private final BooleanProperty modifiedProperty;
  private final BooleanProperty newProperty;

  public CustomerDetailModel() {
    nameProperty = new SimpleStringProperty();
    emailProperty = new SimpleStringProperty();
    phoneNumberProperty = new SimpleStringProperty();
    modifiedProperty = new SimpleBooleanProperty();
    newProperty = new SimpleBooleanProperty();
    nameProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
    emailProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
    phoneNumberProperty.addListener(((observable, oldValue, newValue) -> setModified(true)));
  }

  public StringProperty nameProperty() { return nameProperty; }
  public StringProperty emailProperty() { return emailProperty; }
  public StringProperty phoneNumberProperty() { return phoneNumberProperty; }
  public BooleanProperty modifiedProperty() { return modifiedProperty; }
  public BooleanProperty newProperty() { return newProperty; }

  // convenience methods

  public String getName() { return nameProperty.get(); }
  public void setName(String name) { nameProperty.set(name); }
  public String getEmail() { return emailProperty.get(); }
  public void setEmail(String email) { emailProperty.set(email); }
  public String getPhoneNumber() { return phoneNumberProperty.get(); }
  public void setPhoneNumber(String phoneNumber) { phoneNumberProperty.set(phoneNumber); }
  public boolean isModified() { return modifiedProperty.get(); }
  public void setModified(boolean m) { modifiedProperty.set(m); }
  public boolean isNew() { return newProperty.get(); }
  public void setNew(boolean n) { newProperty.set(n); }
}
