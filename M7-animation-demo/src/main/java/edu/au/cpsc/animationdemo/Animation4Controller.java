package edu.au.cpsc.animationdemo;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animation4Controller {

  private static final int START_X = 100;
  private static final int END_X = 0;

  @FXML
  private Button topButton, middleButton, bottomButton;

  @FXML
  protected void inButtonAction() {
    TranslateTransition topButtonTransition = new TranslateTransition(Duration.millis(200), topButton);
    topButtonTransition.setFromX(START_X);
    topButtonTransition.setToX(END_X);
    TranslateTransition middleButtonTransition = new TranslateTransition(Duration.millis(200), middleButton);
    middleButtonTransition.setFromX(START_X);
    middleButtonTransition.setToX(END_X);
    TranslateTransition bottomButtonTransition = new TranslateTransition(Duration.millis(200), bottomButton);
    bottomButtonTransition.setFromX(START_X);
    bottomButtonTransition.setToX(END_X);
    SequentialTransition sequentialTransition = new SequentialTransition(topButtonTransition, middleButtonTransition, bottomButtonTransition);
    sequentialTransition.playFromStart();
  }

  @FXML
  protected void outButtonAction() {
    TranslateTransition topButtonTransition = new TranslateTransition(Duration.millis(200), topButton);
    topButtonTransition.setFromX(END_X);
    topButtonTransition.setToX(START_X);
    TranslateTransition middleButtonTransition = new TranslateTransition(Duration.millis(200), middleButton);
    middleButtonTransition.setFromX(END_X);
    middleButtonTransition.setToX(START_X);
    TranslateTransition bottomButtonTransition = new TranslateTransition(Duration.millis(200), bottomButton);
    bottomButtonTransition.setFromX(END_X);
    bottomButtonTransition.setToX(START_X);
    SequentialTransition sequentialTransition = new SequentialTransition(bottomButtonTransition, middleButtonTransition, topButtonTransition);
    sequentialTransition.playFromStart();
  }

}
