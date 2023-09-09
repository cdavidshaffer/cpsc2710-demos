package edu.au.cpsc.customer.uimodel;


import java.util.Objects;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CustomerDetailModel {

  private final StringProperty nameProperty;
  private final StringProperty emailProperty;
  private final StringProperty phoneNumberProperty;
  private final BooleanProperty isNewProperty;
  private final BooleanProperty isModifiedProperty;

  public CustomerDetailModel() {
    nameProperty = new SimpleStringProperty();
    emailProperty = new SimpleStringProperty();
    phoneNumberProperty = new SimpleStringProperty();
    isNewProperty = new SimpleBooleanProperty();
    isModifiedProperty = new SimpleBooleanProperty();
    // listen for changes and update our modified property
    ModifiedListener<String> ml = new ModifiedListener<>();
    nameProperty.addListener(ml);
    emailProperty.addListener(ml);
    phoneNumberProperty.addListener(ml);
  }

  public StringProperty nameProperty() { return nameProperty; }
  public StringProperty emailProperty() { return emailProperty; }
  public StringProperty phoneNumberProperty() { return phoneNumberProperty; }
  public BooleanProperty isNewProperty() { return isNewProperty; }
  public BooleanProperty isModifiedProperty() { return isModifiedProperty; }

  public String getName() { return nameProperty.get(); }
  public void setName(String name) { nameProperty.set(name); }
  public String getEmail() { return emailProperty.get(); }
  public void setEmail(String email) { emailProperty.set(email); }
  public String getPhoneNumber() { return phoneNumberProperty.get(); }
  public void setPhoneNumber(String phoneNumber) { phoneNumberProperty.set(phoneNumber); }
  public boolean isNew() { return isNewProperty.get(); }
  public void setNew(boolean n) { isNewProperty.set(n); }
  public boolean isModified() { return isModifiedProperty.get(); }
  public void setModified(boolean m) { isModifiedProperty.set(m); }

  class ModifiedListener<T> implements ChangeListener<T> {

    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
      if (!Objects.equals(oldValue, newValue)) {
        setModified(true);
      }
    }
  }
}
