package edu.au.cpsc.tabpanedemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TabPaneController {

  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}