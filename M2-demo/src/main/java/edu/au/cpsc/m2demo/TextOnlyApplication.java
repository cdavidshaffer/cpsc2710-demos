package edu.au.cpsc.m2demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextOnlyApplication extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Text text = new Text("Hello World");
    StackPane root = new StackPane(text);
    Scene scene = new Scene(root, 300, 300);
    stage.setScene(scene);
    stage.show();
  }

}