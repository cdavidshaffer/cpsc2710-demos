module edu.au.cpsc.animationplay {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.animationdemo to javafx.fxml;
  exports edu.au.cpsc.animationdemo;
}