package com.example.csspropertiesdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CssPropertiesDemoController {

  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}