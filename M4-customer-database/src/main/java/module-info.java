module edu.au.cpsc.composingviews {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.au.cpsc.customer to javafx.fxml;
  exports edu.au.cpsc.customer;
  exports edu.au.cpsc.customer.model;
  opens edu.au.cpsc.customer.model to javafx.fxml;
  exports edu.au.cpsc.customer.controller;
  opens edu.au.cpsc.customer.controller to javafx.fxml;
}