package edu.au.cpsc.fontsandimportdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FontsAndImportApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(FontsAndImportApplication.class.getResource("fonts-and-import-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Hello!");
    stage.setScene(scene);
//    scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Heebo");
//    scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Pacifico");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}