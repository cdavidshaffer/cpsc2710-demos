package edu.au.cpsc.multiwindow.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LauncherApplicationController {

  /**
   * Open the customer table-with-editor window.
   *
   * @throws IOException if FXML fails to load
   */
  @FXML
  protected void customerEditorAction() throws IOException {
    // Option 1: create stage and load FXML in launcher
    Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "/windows/customer-table-with-editor-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Table With Editor");
    stage.setScene(scene);
    stage.show();
  }


  /**
   * Open the customer table window that shows a dialog when the user clicks an edit button.
   *
   * @throws IOException if FXML fails to load
   */
  @FXML
  protected void customerWithPopupAction() throws IOException {
    // Option 2: Call static method in controller (my preference)
    CustomerTableWithButtonsApplicationController.show();
  }

  @FXML
  protected void accountsReceivableAction() {
    new Alert(AlertType.INFORMATION, "TBD").showAndWait();
  }


}
