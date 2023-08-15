package edu.au.cpsc.eventdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventDemo extends Application {

  @Override
  public void start(Stage stage) throws Exception {

    // Create an Ellipse and set fill color
    Ellipse ellipse = new Ellipse(110, 70);
    ellipse.setFill(Color.LIGHTBLUE);

    // Create a Text shape with font and size
    Text text = new Text("My Shapes");
    text.setFont(new Font("Arial Bold", 24));

    ellipse.setOnMouseClicked(event -> ellipseMouseClicked(text, event));
    text.setOnMouseClicked(event -> textMouseClicked(event));

    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(ellipse, text);
    Scene scene = new Scene(stackPane, 350, 230,
        Color.LIGHTYELLOW);
    stage.setTitle("MyShapes with JavaFX");
    stage.setScene(scene);
    stage.show();
  }

  private void ellipseMouseClicked(Text text, MouseEvent event) {
    text.setText("Ellipse clicked: "+event);
  }

  private static void textMouseClicked(MouseEvent event) {
    System.out.println("Text clicked: "+event);
    System.out.println("Foo");
  }


}

