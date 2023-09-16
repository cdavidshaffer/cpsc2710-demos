module edu.au.cpsc.deployingmacos {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.deployingmacos to javafx.fxml;
  exports edu.au.cpsc.deployingmacos;
}