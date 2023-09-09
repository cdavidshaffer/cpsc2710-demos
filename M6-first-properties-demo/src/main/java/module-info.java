module edu.au.cpsc.firstpropertiesdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.firstpropertiesdemo to javafx.fxml;
  exports edu.au.cpsc.firstpropertiesdemo;
}