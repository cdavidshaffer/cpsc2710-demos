module edu.au.cpsc.demofirststyle {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.demofirststyle to javafx.fxml;
  exports edu.au.cpsc.demofirststyle;
}