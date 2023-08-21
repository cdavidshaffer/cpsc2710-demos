package edu.au.cpsc.customer.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatabaseManager {

  private static CustomerDatabase customerDatabase = null;

  public static CustomerDatabase getCustomerDatabase() {
    if (customerDatabase == null)
      try {
        customerDatabase = loadCustomerDatabase();
      } catch (IOException ex) {
        customerDatabase = new CustomerDatabase();
      } catch (ClassNotFoundException ex) {
        Alert error = new Alert(AlertType.ERROR, "Internal error loading database: class not found");
        error.showAndWait();
      }
    return customerDatabase;
  }

  private static CustomerDatabase loadCustomerDatabase() throws IOException, ClassNotFoundException {
    return CustomerDatabaseIO.load(new FileInputStream(CustomerDatabaseIO.DEFAULT_FILE));
  }

  public static void saveCustomerDatabase() {
    try {
      CustomerDatabaseIO.save(getCustomerDatabase(), new FileOutputStream(CustomerDatabaseIO.DEFAULT_FILE));
    } catch (IOException e) {
      Alert error = new Alert(AlertType.ERROR, "Unable to save file " + CustomerDatabaseIO.DEFAULT_FILE);
      error.showAndWait();
    }
  }

}
