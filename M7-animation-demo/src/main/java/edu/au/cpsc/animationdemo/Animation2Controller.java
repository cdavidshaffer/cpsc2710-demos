package edu.au.cpsc.animationdemo;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Animation2Controller {

  @FXML
  private Ellipse ellipse;

  @FXML
  protected void goButtonAction() {
    RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), ellipse);
    rotateTransition.setFromAngle(0);
    rotateTransition.setToAngle(360);
    rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
    rotateTransition.playFromStart();
  }

}
