package edu.au.cpsc.dynamicstyleclassdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

  @FXML
  private Label welcomeText;

  @FXML
  private Button helloButton;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
    helloButton.getStyleClass().add("clicked");
  }
}