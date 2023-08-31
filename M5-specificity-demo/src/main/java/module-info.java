module edu.au.cpsc.inheritancedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.specificitydemo to javafx.fxml;
  exports edu.au.cpsc.specificitydemo;
}