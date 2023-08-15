module edu.au.cpsc2710.piedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc2710.piedemo to javafx.fxml;
  exports edu.au.cpsc2710.piedemo;
}