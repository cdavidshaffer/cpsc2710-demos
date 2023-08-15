package edu.au.cpsc.firstfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HelloController implements Initializable {

  @FXML
  private Label welcomeText;

  @FXML
  private ComboBox<String> namesCombobox;



  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }

  @FXML
  protected void comboboxOnAction() {
    welcomeText.setText("Welcome "+namesCombobox.getValue());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    namesCombobox.setItems(FXCollections.observableArrayList("Fred", "Barney", "Wilma", "Betty"));
  }
}