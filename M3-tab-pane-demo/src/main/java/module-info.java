module edu.au.cpsc.tabpanedemo {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.ikonli.javafx;

  opens edu.au.cpsc.tabpanedemo to javafx.fxml;
  exports edu.au.cpsc.tabpanedemo;
}