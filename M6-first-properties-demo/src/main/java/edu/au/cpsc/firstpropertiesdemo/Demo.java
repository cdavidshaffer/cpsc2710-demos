package edu.au.cpsc.firstpropertiesdemo;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Demo {

  public static void main(String[] args) {
    announce("Property basics");
    SimpleObjectProperty<String> nameProperty = new SimpleObjectProperty<>();
    nameProperty.set("Bob");
    System.out.println(nameProperty.get());
    nameProperty.set("Fred");
    System.out.println(nameProperty.get());

    SimpleObjectProperty<String> emailProperty = new SimpleObjectProperty<>("b@here.net");
    System.out.println(emailProperty.get());

    SimpleIntegerProperty ageProperty = new SimpleIntegerProperty();
    System.out.println(ageProperty.get());
    ageProperty.set(10);
    System.out.println(ageProperty.get());

    announce("Listeners");
    nameProperty.addListener((observable, oldValue, newValue) -> System.out.println("name changed from "+oldValue+" to "+newValue));
    nameProperty.set("Wilma");
    nameProperty.addListener((observable, oldValue, newValue) -> System.out.println("second listener heard that name changed"));
    announce("Two listeners");
    nameProperty.set("Dino");

    announce("Bind");
    SimpleObjectProperty<String> secondNameProperty = new SimpleObjectProperty<>();
    secondNameProperty.bind(nameProperty);
    System.out.println(secondNameProperty.get());
    nameProperty.set("Betty");
    System.out.println(secondNameProperty.get());
    secondNameProperty.addListener((observable, oldValue, newValue) -> System.out.println("second name property changed from "+oldValue+" to "+newValue));
    announce("Setting nameProperty");
    nameProperty.set("Barney");

    // secondNameProperty.set("George Jetson");   // this throws exception!!!
    announce("Printing properties");
    System.out.println(nameProperty);
    System.out.println(secondNameProperty);

    announce("Bidirectional bindings");
    SimpleIntegerProperty yearProperty = new SimpleIntegerProperty(2023);
    SimpleIntegerProperty secondYearProperty = new SimpleIntegerProperty();
    secondYearProperty.bindBidirectional(yearProperty);
    System.out.println(yearProperty);
    System.out.println(secondYearProperty);

    yearProperty.set(1990);
    System.out.println(yearProperty.get());
    System.out.println(secondYearProperty.get());

    secondYearProperty.set(2020);
    System.out.println(yearProperty.get());
    System.out.println(secondYearProperty.get());
  }

  private static void announce(String announcement) {
    System.out.println("----------------"+announcement);
  }

}
