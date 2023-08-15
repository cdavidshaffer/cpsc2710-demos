package edu.au.cpsc.accordiondemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccordionController {

  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}