module com.example.listviewdemo {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.listview to javafx.fxml;
  exports edu.au.cpsc.listview;
}