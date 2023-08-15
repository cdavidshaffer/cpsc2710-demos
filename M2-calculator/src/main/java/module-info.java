module edu.au.cpsc.calculator {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.calculator to javafx.fxml;
  exports edu.au.cpsc.calculator;
}