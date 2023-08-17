package edu.au.cpsc.customevents;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerAlertApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerAlertApplication.class.getResource("customer-alert-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer alerts");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}