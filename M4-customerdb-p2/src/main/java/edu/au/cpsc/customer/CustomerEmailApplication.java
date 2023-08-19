package edu.au.cpsc.customer;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerEmailApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerEmailApplication.class.getResource("/apps/customer-email-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer Email App");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}