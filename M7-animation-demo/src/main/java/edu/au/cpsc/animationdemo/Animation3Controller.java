package edu.au.cpsc.animationdemo;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Animation3Controller {

  @FXML
  private Ellipse ellipse;

  @FXML
  protected void goButtonAction() {
    RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), ellipse);
    rotateTransition.setFromAngle(0);
    rotateTransition.setToAngle(360);
    rotateTransition.setInterpolator(Interpolator.LINEAR);
    FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), ellipse);
    fadeTransition.setFromValue(1.0);
    fadeTransition.setToValue(0.0);
    fadeTransition.setAutoReverse(true);
    fadeTransition.setCycleCount(2);
    ParallelTransition parallelTransition = new ParallelTransition();
    parallelTransition.getChildren().addAll(rotateTransition, fadeTransition);
    parallelTransition.playFromStart();
  }

}
