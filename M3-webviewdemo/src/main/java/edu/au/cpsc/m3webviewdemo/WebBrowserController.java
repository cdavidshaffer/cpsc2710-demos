package edu.au.cpsc.m3webviewdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class WebBrowserController {

  @FXML
  private TextField urlTextField;

  @FXML
  private WebView webView;

  @FXML
  protected void urlTextFieldAction() {
    String url = urlTextField.getText();
    webView.getEngine().load(url);
  }
}