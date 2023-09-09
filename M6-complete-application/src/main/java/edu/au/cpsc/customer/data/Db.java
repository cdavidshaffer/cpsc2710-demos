package edu.au.cpsc.customer.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Db {

  public static final File DEFAULT_FILE = new File("customers.dat");

  private static CustomerDatabase customerDatabase = null;

  public static CustomerDatabase getDatabase() {
    // lazy initialization
    if (customerDatabase == null)
      customerDatabase = loadDatabase();
    return customerDatabase;
  }

  private static CustomerDatabase loadDatabase() {
    try (InputStream is = new FileInputStream(DEFAULT_FILE)) {
      return CustomerDatabaseIO.load(is);
    } catch (IOException|ClassNotFoundException ex) {
      return new CustomerDatabase();
    }
  }

  public static void saveDatabase() {
    try (OutputStream os = new FileOutputStream(DEFAULT_FILE)) {
      CustomerDatabaseIO.save(getDatabase(), os);
    } catch (IOException ex) {
      System.err.println("Error saving database: "+DEFAULT_FILE);
      ex.printStackTrace();
      System.exit(-1);
    }
  }

}
