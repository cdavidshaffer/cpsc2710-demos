package edu.au.cpsc.demofirststyle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstStyleApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    Rectangle rect1 = new Rectangle(100,100);
    rect1.setLayoutX(50);
    rect1.setLayoutY(50);
    Rectangle rect2 = new Rectangle(100,100);
    rect2.setLayoutX(200);
    rect2.setLayoutY(50);
    Circle circle1 = new Circle(50);
    circle1.setLayoutX(100);
    circle1.setLayoutY(250);
    Circle circle2 = new Circle(50);
    circle2.setLayoutX(250);
    circle2.setLayoutY(250);
    Scene scene = new Scene(new Group(rect1, rect2, circle1, circle2), 350, 350);
    scene.getStylesheets().add(getClass().getResource("test.css").toString());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}