module com.example.csspropertiesdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.csspropertiesdemo to javafx.fxml;
  exports com.example.csspropertiesdemo;
}