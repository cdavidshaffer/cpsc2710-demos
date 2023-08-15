module edu.au.cpsc.accordiondemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.accordiondemo to javafx.fxml;
  exports edu.au.cpsc.accordiondemo;
}