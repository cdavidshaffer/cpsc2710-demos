module edu.au.cpsc.derivedproperties {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.derivedproperties to javafx.fxml;
  exports edu.au.cpsc.derivedproperties;
}