package edu.au.cpsc.animationdemo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Animation5Controller {

  @FXML
  private Circle circle;

  @FXML
  private Text text;

  public void initialize() {
    circle.setStroke(Color.BLACK);
    circle.setStrokeType(StrokeType.INSIDE);
    circle.setStrokeWidth(0);
  }

  @FXML
  public void goButtonAction() {
    Timeline tl = new Timeline();
    tl.getKeyFrames().add(
        new KeyFrame(Duration.ZERO,
            new KeyValue(circle.translateXProperty(),0)));
    tl.getKeyFrames().add(
        new KeyFrame(Duration.millis(500),
            new KeyValue(text.rotateProperty(), 0),
            new KeyValue(text.translateYProperty(), 0)));
    tl.getKeyFrames().add(
        new KeyFrame(Duration.millis(1000),
            new KeyValue(circle.translateXProperty(), 500),
            new KeyValue(text.rotateProperty(), 45),
            new KeyValue(text.translateYProperty(), -500)));

    tl.playFromStart();
  }
}
