package edu.au.cpsc2710.piedemo;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class PieDemoController {

  @FXML
  protected void onOpenButtonAction() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open");
    File selectedFile = fileChooser.showOpenDialog(null);
    System.out.println(selectedFile);

  }

  @FXML
  protected void onSaveButtonAction() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save");
    File selectedFile = fileChooser.showSaveDialog(null);
    System.out.println(selectedFile);
  }

  @FXML
  protected void onAskQuestionButtonAction() {
    Alert a = new Alert(AlertType.CONFIRMATION, "Do you like Pie?",
        ButtonType.YES, ButtonType.NO);
    a.setTitle("Important question");
    a.setHeaderText("Food question");
    a.showAndWait().ifPresent(value -> {
      if (value == ButtonType.YES) {
        new Alert(AlertType.INFORMATION, "Excellent!!!")
            .showAndWait();
      } else {
        new Alert(AlertType.WARNING, "Please see a doctor immediately.")
            .showAndWait();
      }
    });

  }
}