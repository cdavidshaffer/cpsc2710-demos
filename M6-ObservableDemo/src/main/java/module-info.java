module edu.au.cpsc.observabledemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.observabledemo to javafx.fxml;
  exports edu.au.cpsc.observabledemo;
}