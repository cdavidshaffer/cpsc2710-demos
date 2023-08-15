module edu.au.cpsc.fontsandimportdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.fontsandimportdemo to javafx.fxml;
  exports edu.au.cpsc.fontsandimportdemo;
}