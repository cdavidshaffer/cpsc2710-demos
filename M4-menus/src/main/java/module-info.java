module edu.au.cpsc.menus {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.menus to javafx.fxml;
  exports edu.au.cpsc.menus;
}