package edu.au.cpsc.controlsfxdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.control.RangeSlider;

public class HelloController {

  @FXML
  private Label welcomeText;

  @FXML
  private RangeSlider rangeSlider;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}