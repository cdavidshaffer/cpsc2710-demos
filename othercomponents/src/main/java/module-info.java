module edu.au.cpsc.othercomponents {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  requires org.controlsfx.controls;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;

  opens edu.au.cpsc.othercomponents to javafx.fxml;
  exports edu.au.cpsc.othercomponents;
}