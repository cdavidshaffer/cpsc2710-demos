package com.example.listviewdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListViewDemoApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(ListViewDemoApplication.class.getResource("listview-demo-view.fxml"));
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