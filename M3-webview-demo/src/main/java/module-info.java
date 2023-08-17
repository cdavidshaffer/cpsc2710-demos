module edu.au.cpsc.m3webviewdemo {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  opens edu.au.cpsc.m3webviewdemo to javafx.fxml;
  exports edu.au.cpsc.m3webviewdemo;
}