module edu.au.cpsc.installationdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.installationdemo to javafx.fxml;
  exports edu.au.cpsc.installationdemo;
}