module com.example.splitpanedemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc to javafx.fxml;
  exports edu.au.cpsc;
}