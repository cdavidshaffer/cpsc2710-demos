package edu.au.cpsc.modalwindows;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogEditorApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(DialogEditorApplication.class.getResource(
        "/dialog-customer-editor-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Popup editor");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}