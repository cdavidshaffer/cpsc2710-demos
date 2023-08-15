module edu.au.cpsc.eventdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.eventdemo to javafx.fxml;
  exports edu.au.cpsc.eventdemo;
}