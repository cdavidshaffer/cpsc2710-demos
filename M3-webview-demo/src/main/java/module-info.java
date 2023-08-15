module edu.au.cpsc.webviewdemo {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  opens edu.au.cpsc.webviewdemo to javafx.fxml;
  exports edu.au.cpsc.webviewdemo;
}