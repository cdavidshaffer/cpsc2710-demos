module edu.au.cpsc.extractdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.extractdemo to javafx.fxml;
  exports edu.au.cpsc.extractdemo;
}