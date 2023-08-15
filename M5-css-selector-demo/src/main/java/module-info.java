module edu.au.cpsc.cssselectordemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.cssselectordemo to javafx.fxml;
  exports edu.au.cpsc.cssselectordemo;
}