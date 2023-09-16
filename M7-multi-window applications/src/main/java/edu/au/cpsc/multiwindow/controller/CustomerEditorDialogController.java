package edu.au.cpsc.multiwindow.controller;

import edu.au.cpsc.multiwindow.LauncherApplication;
import edu.au.cpsc.multiwindow.model.Customer;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class CustomerEditorDialogController {

  public static CustomerEditorDialogController showModal(Customer customer, Window owner) throws IOException {
    Stage stage = new Stage(StageStyle.UTILITY);
    FXMLLoader fxmlLoader = new FXMLLoader(LauncherApplication.class.getResource(
        "/windows/customer-editor-dialog.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer Editor");
    CustomerEditorDialogController controller = fxmlLoader.getController();
    controller.editCustomer(customer);
    stage.setScene(scene);
    //Modality demo...
    stage.initModality(Modality.WINDOW_MODAL);
    stage.initOwner(owner);
    stage.showAndWait();
    System.out.println("Window closed");
    return controller;
  }

  private void editCustomer(Customer customer) {
    customerDetailEditorController.showCustomer(customer);
  }

  @FXML
  private Parent customerDetailEditor;

  @FXML
  private CustomerDetailEditorController customerDetailEditorController;

  @FXML
  private void saveButtonAction() {

  }

  @FXML
  private void cancelButtonAction() {

  }

}
