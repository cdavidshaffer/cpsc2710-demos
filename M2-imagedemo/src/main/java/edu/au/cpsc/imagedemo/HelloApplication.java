package edu.au.cpsc.imagedemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
  public static final String CAT_FILE_NAME = "/cat.jpg";

  @Override
  public void start(Stage stage) throws Exception {
    Image im = new Image(getClass().getResource(CAT_FILE_NAME).toExternalForm(), 300, 300, true, false);
    ImageView iv = new ImageView(im);

    StackPane root = new StackPane(iv);
    Scene scene = new Scene(root, 300, 300);
    scene.setFill(Color.BLACK);
    stage.setScene(scene);
    stage.show();
  }

}