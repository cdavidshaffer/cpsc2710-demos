module edu.au.cpsc.firstfxml {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.firstfxml to javafx.fxml;
  exports edu.au.cpsc.firstfxml;
}