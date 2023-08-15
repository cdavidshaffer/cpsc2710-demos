module edu.au.cpsc.toolbardemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.toolbardemo to javafx.fxml;
  exports edu.au.cpsc.toolbardemo;
}