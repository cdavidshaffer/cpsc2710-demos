package edu.au.cpsc.firststyling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstStylingApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(FirstStylingApplication.class.getResource("first-styling-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Style!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}