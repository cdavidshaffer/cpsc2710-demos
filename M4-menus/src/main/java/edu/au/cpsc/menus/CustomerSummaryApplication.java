package edu.au.cpsc.menus;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Show the Customer Summary window.
 *
 * <p>Note that this Application is not necessary since we only plan to open this window
 * via the LauncherApplication which could perform my duties if it wanted to.  This class
 * is here only to show it as an option (Approach 1) to building a multi-window application.</p>
 */
public class CustomerSummaryApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CustomerSummaryApplication.class.getResource("/customer-summary-app.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}