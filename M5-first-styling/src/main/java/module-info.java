module edu.au.cpsc.firststyling {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.firststyling to javafx.fxml;
  exports edu.au.cpsc.firststyling;
}