module edu.au.cpsc.nodepropertiesdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.nodepropertiesdemo to javafx.fxml;
  exports edu.au.cpsc.nodepropertiesdemo;
}