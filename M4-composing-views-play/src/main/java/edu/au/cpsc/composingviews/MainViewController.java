package edu.au.cpsc.composingviews;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainViewController {

  @FXML
  private Parent helloView;

  @FXML
  private HelloController helloViewController;

  @FXML
  private Parent otherView;

  @FXML
  private OtherViewController otherViewController;

  @FXML
  private void initialize() {
    System.out.println("init: "+helloViewController+"   "+otherViewController);
  }

}
