package edu.au.cpsc.animationdemo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Animation3Application extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(Animation1Application.class.getResource("animation3-view.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 320, 240);
      primaryStage.setTitle("Animation 3");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
