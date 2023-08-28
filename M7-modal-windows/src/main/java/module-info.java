module edu.au.cpsc.modalwindows {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.modalwindows to javafx.fxml;
  exports edu.au.cpsc.modalwindows;
}