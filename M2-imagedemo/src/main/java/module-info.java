module edu.au.cpsc.imagedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.imagedemo to javafx.fxml;
  exports edu.au.cpsc.imagedemo;
}