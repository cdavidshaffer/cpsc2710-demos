module edu.au.cpsc.m2demo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.m2demo to javafx.fxml;
  exports edu.au.cpsc.m2demo;
}