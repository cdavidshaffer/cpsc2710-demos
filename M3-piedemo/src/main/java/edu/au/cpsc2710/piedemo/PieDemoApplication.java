package edu.au.cpsc2710.piedemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PieDemoApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(PieDemoApplication.class.getResource("pie-demo-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Pie!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}