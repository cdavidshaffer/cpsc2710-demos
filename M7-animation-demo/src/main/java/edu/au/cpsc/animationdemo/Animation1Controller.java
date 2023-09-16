package edu.au.cpsc.animationdemo;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Animation1Controller {

  @FXML
  private Label helloWorldLabel;

  @FXML
  protected void onFadeAction() {
    FadeTransition fade = new FadeTransition(Duration.millis(100), helloWorldLabel);
    fade.setFromValue(1.0);
    fade.setToValue(0.0);
    fade.setCycleCount(4);
    fade.setAutoReverse(true);
    fade.playFromStart();
  }
}