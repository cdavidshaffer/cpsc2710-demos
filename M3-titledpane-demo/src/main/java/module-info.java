module edu.au.cpsc.titledpanedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.titledpanedemo to javafx.fxml;
  exports edu.au.cpsc.titledpanedemo;
}