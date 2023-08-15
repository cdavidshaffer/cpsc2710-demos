package edu.au.cpsc.containercontrols;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;

public class ButtonBarDemoController implements Initializable {

  @FXML
  private Label welcomeText;

  @FXML
  private Button cancelButton;

  @FXML
  private Button helpButton;

  @FXML
  private Button okButton;

  @FXML
  protected void okButtonAction() {
    System.out.println("OK");
  }

  @FXML
  protected void cancelButtonAction() {
    System.out.println("Cancel");
  }


  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ButtonBar.setButtonData(cancelButton, ButtonData.CANCEL_CLOSE);
    ButtonBar.setButtonData(okButton, ButtonData.OK_DONE);
    ButtonBar.setButtonData(helpButton, ButtonData.HELP);
  }
}