package edu.au.cpsc.selectorsdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectorsDemoApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SelectorsDemoApplication.class.getResource("selectors-demo-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("CSS selectors");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}