module edu.au.cpsc.tableviewdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.tableviewdemo to javafx.fxml;
  exports edu.au.cpsc.tableviewdemo;
}