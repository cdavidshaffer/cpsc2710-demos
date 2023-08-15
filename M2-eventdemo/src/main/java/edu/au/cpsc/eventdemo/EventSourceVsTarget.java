package edu.au.cpsc.eventdemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventSourceVsTarget extends Application implements EventHandler<MouseEvent> {


  @Override
  public void start(Stage stage) throws Exception {
    // Create an Ellipse and set fill color
    Ellipse ellipse = new Ellipse(110, 70);
    ellipse.setFill(Color.LIGHTBLUE);

    // Create a Text shape with font and size
    Text text = new Text("My Shapes");
    text.setFont(new Font("Arial Bold", 24));
    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(ellipse, text);

    Scene scene = new Scene(stackPane, 350, 230,
        Color.LIGHTYELLOW);
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    stage.setTitle("MyShapes with JavaFX");
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("Something was clicked: t = "+event.getTarget()+ "  s = "+event.getSource());
  }

}