package edu.au.cpsc.multiwindow.application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(LauncherApplication.class.getResource(
        "/windows/launcher-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Launcher");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}