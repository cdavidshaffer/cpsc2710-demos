module edu.au.cpsc.dynamicstyleclassdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.dynamicstyleclassdemo to javafx.fxml;
  exports edu.au.cpsc.dynamicstyleclassdemo;
}