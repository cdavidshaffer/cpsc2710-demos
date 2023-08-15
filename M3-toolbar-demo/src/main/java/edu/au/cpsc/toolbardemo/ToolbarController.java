package edu.au.cpsc.toolbardemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ToolbarController {

  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}