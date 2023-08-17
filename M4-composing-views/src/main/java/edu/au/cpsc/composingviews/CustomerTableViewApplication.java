package edu.au.cpsc.composingviews;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerTableViewApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerTableViewApplication.class.getResource("customer-table-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer Table View");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}