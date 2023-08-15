package edu.au.cpsc.calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {

  private enum Operation {
    NONE, PLUS, MINUS, TIMES, DIVIDE;
  }

  private TextField textField;

  private int registerY;

  private Operation currentOperation = Operation.NONE;

  @Override
  public void start(Stage stage) {
    textField = new TextField();
    textField.setPrefWidth(10);
    textField.setAlignment(Pos.CENTER_RIGHT);
    textField.setEditable(false);
    GridPane buttonPane = createGridPane();
    VBox root = new VBox(textField, buttonPane);
    VBox.setVgrow(buttonPane, Priority.ALWAYS);
    Scene scene = new Scene(root);
    stage.setTitle("CPSC Calculator");
    stage.setScene(scene);
    stage.show();
  }

  private GridPane createGridPane() {
    GridPane buttonPane = new GridPane();
    addNumericButtons(buttonPane);
    addOperatorButtons(buttonPane);
    addClearButtons(buttonPane);
    return buttonPane;
  }

  private void addClearButtons(GridPane buttonPane) {
    Button clearButton = new Button("C");
    clearButton.setOnAction(event -> clearButtonAction());
    buttonPane.add(clearButton, 4, 2);
    Button allClearButton = new Button("AC");
    allClearButton.setOnAction(event -> allClearButtonAction());
    buttonPane.add(allClearButton, 4, 3);
  }

  private void addOperatorButtons(GridPane buttonPane) {
    Button plusButton = new Button("+");
    plusButton.setOnAction(event -> operatorButtonAction(Operation.PLUS));
    buttonPane.add(plusButton, 3, 0);
    Button minusButton = new Button("-");
    minusButton.setOnAction(event -> operatorButtonAction(Operation.MINUS));
    buttonPane.add(minusButton, 3, 1);
    Button timesButton = new Button("*");
    timesButton.setOnAction(event -> operatorButtonAction(Operation.TIMES));
    buttonPane.add(timesButton, 3, 2);
    Button divideButton = new Button("/");
    divideButton.setOnAction(event -> operatorButtonAction(Operation.DIVIDE));
    buttonPane.add(divideButton, 3, 3);
    Button equalsButton = new Button("=");
    equalsButton.setOnAction(event -> equalsButtonAction());
    buttonPane.add(equalsButton, 4, 0, 1, 2);
  }

  private void addNumericButtons(GridPane buttonPane) {
    for (int i = 0; i < 9; i++) {
      Button b = new Button(String.valueOf(i + 1));
      final int digit = i + 1;
      b.setOnAction(event -> numericButtonAction(digit));
      buttonPane.add(b, i % 3, 2 - i / 3);
    }
    Button zeroButton = new Button("0");
    zeroButton.setOnAction(event -> numericButtonAction(0));
    buttonPane.add(zeroButton, 0, 3, 3, 1);
  }

  private void allClearButtonAction() {
    clearButtonAction();
    registerY = 0;
    currentOperation = Operation.NONE;
  }

  private void equalsButtonAction() {
    var result = Integer.parseInt(textField.getText());
    switch (currentOperation) {
      case NONE:
        break;
      case PLUS:
        result += registerY;
        break;
      case MINUS:
        result = registerY - result;
        break;
      case TIMES:
        result *= registerY;
        break;
      case DIVIDE:
        result = registerY / result;
    }
    textField.setText(String.valueOf(result));
  }

  private void operatorButtonAction(Operation o) {
    if (currentOperation != Operation.NONE)
      equalsButtonAction();
    registerY = Integer.parseInt(textField.getText());
    currentOperation = o;
    textField.clear();
  }

  private void clearButtonAction() {
    textField.clear();
  }

  private void numericButtonAction(int digit) {
    textField.appendText(String.valueOf(digit));
  }

  public static void main(String[] args) {
    launch();
  }
}