package edu.au.cpsc.customer;

import edu.au.cpsc.customer.data.CustomerDatabase;
import edu.au.cpsc.customer.data.CustomerDatabaseIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CustomerOverviewApplication extends Application {

  private static CustomerDatabase customerDatabase;

  public static CustomerDatabase getCustomerDatabase() {
    if (customerDatabase == null) {
      try {
        customerDatabase = loadCustomerDatabase();
      } catch (IOException ex) {
        // if we fail to load the database, just create a new empty one
        customerDatabase = new CustomerDatabase();
      }
    }
    return customerDatabase;
  }

  public static void saveCustomerDatabase() {
    try {
      CustomerDatabaseIO.save(getCustomerDatabase(), new FileOutputStream(CustomerDatabaseIO.DEFAULT_FILE));
    } catch (IOException e) {
      Alert error = new Alert(AlertType.ERROR, "Failed to save database.");
      error.showAndWait();
    }
  }

  private static CustomerDatabase loadCustomerDatabase() throws IOException {
    return CustomerDatabaseIO.load(new FileInputStream(CustomerDatabaseIO.DEFAULT_FILE));
  }

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
        CustomerOverviewApplication.class.getResource("/apps/customer-overview-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer Table App");
    stage.setScene(scene);
    getCustomerDatabase();
    saveCustomerDatabase();
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
