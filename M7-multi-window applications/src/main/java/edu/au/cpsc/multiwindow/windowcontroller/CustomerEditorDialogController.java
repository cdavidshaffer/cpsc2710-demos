package edu.au.cpsc.multiwindow.windowcontroller;

import edu.au.cpsc.multiwindow.application.LauncherApplication;
import edu.au.cpsc.multiwindow.model.Customer;
import edu.au.cpsc.multiwindow.viewcontroller.CustomerDetailEditorController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerEditorDialogController {

  public static CustomerEditorDialogController showModal(Customer customer) throws IOException {
    Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(LauncherApplication.class.getResource(
        "/windows/customer-editor-dialog.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Customer Editor");
    CustomerEditorDialogController controller = fxmlLoader.getController();
    controller.editCustomer(customer);
    stage.setScene(scene);
    //Modality demo...
    //stage.initModality(Modality.APPLICATION_MODAL);
    stage.show();
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
