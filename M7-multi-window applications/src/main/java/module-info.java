module edu.au.cpsc.composingviews {
    requires javafx.controls;
    requires javafx.fxml;

  exports edu.au.cpsc.multiwindow.controller;
  opens edu.au.cpsc.multiwindow.controller to javafx.fxml;
  exports edu.au.cpsc.multiwindow.model;
  exports edu.au.cpsc.multiwindow;
}