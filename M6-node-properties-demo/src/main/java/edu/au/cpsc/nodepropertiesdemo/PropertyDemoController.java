package edu.au.cpsc.nodepropertiesdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Ellipse;

public class PropertyDemoController {

  @FXML
  private Label topLabel;

  @FXML
  private Ellipse ellipse;

  @FXML
  private Slider radiusXSlider, radiusYSlider, rotationSlider;

  public void initialize() {
    ellipse.radiusXProperty().bind(radiusXSlider.valueProperty());
    ellipse.radiusYProperty().bind(radiusYSlider.valueProperty());
    ellipse.rotateProperty().bind(rotationSlider.valueProperty().multiply(2));
  }

  @FXML
  protected void changeButtonAction() {
    //topLabel.setText("Whatever");
    topLabel.textProperty().set("Whatever (via properties)");
  }

  @FXML
  protected void enlargeButtonAction() {
    //ellipse.setRadiusX(350);
    ellipse.radiusXProperty().set(350);
  }


}