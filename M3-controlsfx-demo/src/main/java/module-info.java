module edu.au.cpsc.controlsfxdemo {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;

  opens edu.au.cpsc.controlsfxdemo to javafx.fxml;
  exports edu.au.cpsc.controlsfxdemo;
}