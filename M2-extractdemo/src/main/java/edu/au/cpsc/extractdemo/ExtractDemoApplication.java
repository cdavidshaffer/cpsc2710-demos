package edu.au.cpsc.extractdemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ExtractDemoApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    BorderPane borderPane = createRoot();
    Scene scene = new Scene(borderPane, 1024, 768);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  private BorderPane createRoot() {
    Node centerPane = createCenterPane();
    VBox rightButtons = createRightButtons();
    HBox bottomButtons = createBottomButtons();
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(centerPane);
    borderPane.setRight(rightButtons);
    borderPane.setBottom(bottomButtons);
    return borderPane;
  }

  private static HBox createBottomButtons() {
    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel");
    return new HBox(cancelButton, saveButton);
  }

  private static VBox createRightButtons() {
    Button newButton = new Button("New");
    Button deleteButton = new Button("Delete");
    Button propertiesButton = new Button("Properties");
    Button moveButton = new Button("Move");
    VBox rightButtons = new VBox(newButton, deleteButton, propertiesButton, moveButton);
    rightButtons.setAlignment(Pos.TOP_CENTER);
    return rightButtons;
  }

  private Node createCenterPane() {
    Rectangle rectangle = new Rectangle(100, 200);
    rectangle.setFill(Color.AQUA);
    return new Group(rectangle);
  }

  public static void main(String[] args) {
    launch();
  }
}