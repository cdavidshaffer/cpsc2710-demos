module edu.au.cpsc.inheritancedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.inheritancedemo to javafx.fxml;
  exports edu.au.cpsc.inheritancedemo;
}