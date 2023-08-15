package edu.au.cpsc.webviewdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WebViewController {

  @FXML
  private TextField urlTextField;

  @FXML
  private javafx.scene.web.WebView webView;

  @FXML
  protected void urlTextFieldAction() {
    webView.getEngine().load(urlTextField.getText());
  }
}