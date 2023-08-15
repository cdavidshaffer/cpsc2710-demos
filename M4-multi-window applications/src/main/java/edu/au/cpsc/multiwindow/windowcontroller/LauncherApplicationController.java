package edu.au.cpsc.multiwindow.windowcontroller;

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
    Stage stage = new Stage();
    showWindow(stage, "/windows/customer-table-with-editor-app.fxml", "Table With Editor");
  }


  /**
   * Open the customer table window that shows a dialog when the user clicks an edit button.
   *
   * @throws IOException if FXML fails to load
   */
  @FXML
  protected void customerAlertsAction() throws IOException {
    Stage stage = new Stage();
    showWindow(stage, "/windows/customer-table-wth-buttons-app.fxml", "Table");
  }

  @FXML
  protected void accountsReceivableAction() {
    (new Alert(AlertType.INFORMATION, "TBD")).showAndWait();
  }

  private void showWindow(Stage stage, String name, String title) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        name));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle(title);
    stage.setScene(scene);
    stage.show();
  }


}
