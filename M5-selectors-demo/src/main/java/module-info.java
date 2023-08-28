module edu.au.cpsc.selectorsdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.selectorsdemo to javafx.fxml;
  exports edu.au.cpsc.selectorsdemo;
}