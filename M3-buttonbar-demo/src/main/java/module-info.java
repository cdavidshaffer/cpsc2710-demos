module edu.au.cpsc.containercontrols {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.containercontrols to javafx.fxml;
  exports edu.au.cpsc.containercontrols;
}