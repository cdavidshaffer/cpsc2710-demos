module edu.au.cpsc.composingviews {
    requires javafx.controls;
    requires javafx.fxml;

  exports edu.au.cpsc.multiwindow.viewcontroller;
  opens edu.au.cpsc.multiwindow.viewcontroller to javafx.fxml;
  exports edu.au.cpsc.multiwindow.model;
  opens edu.au.cpsc.multiwindow.model to javafx.fxml;
  exports edu.au.cpsc.multiwindow.application;
  opens edu.au.cpsc.multiwindow.application to javafx.fxml;
  exports edu.au.cpsc.multiwindow.windowcontroller;
  opens edu.au.cpsc.multiwindow.windowcontroller to javafx.fxml;
}