module com.example.m1gitfromij {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.m1gitfromij to javafx.fxml;
  exports com.example.m1gitfromij;
}