module edu.au.cpsc.textbookpropertiesdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.textbookpropertiesdemo to javafx.fxml;
  exports edu.au.cpsc.textbookpropertiesdemo;
}