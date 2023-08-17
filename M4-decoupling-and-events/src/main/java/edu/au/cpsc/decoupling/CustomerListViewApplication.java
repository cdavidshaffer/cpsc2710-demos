package edu.au.cpsc.decoupling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerListViewApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerListViewApplication.class.getResource("customer-list-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setMinHeight(300);
    stage.setMinWidth(300);
    stage.setTitle("ListView demo");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}