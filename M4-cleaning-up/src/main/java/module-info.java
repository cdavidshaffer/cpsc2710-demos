module edu.au.cpsc.composingviews {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.customer to javafx.fxml;
  exports edu.au.cpsc.customer;
}