module com.example.listviewdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.listviewdemo to javafx.fxml;
  exports com.example.listviewdemo;
}