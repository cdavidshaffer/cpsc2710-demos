package edu.au.cpsc.derivedproperties;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Demo {

  public static void main(String[] args) {

    announce("Booleans");
    var a = new SimpleBooleanProperty(false);
    var b = new SimpleBooleanProperty(false);

    var c = a.or(b);
    System.out.println(c.get());

    a.set(true);
    System.out.println(c.get());

    var d = a.and(b);
    System.out.println(d.get());
    b.set(true);
    System.out.println(d.get());

    var e = a.not();
    System.out.println(e.get());
    a.set(false);
    System.out.println(e.get());

    announce("Strings");
    var sa = new SimpleStringProperty("Fred");
    var sb = sa.concat(" Flintstone");
    System.out.println(sb.get());

    sa.set("Wilma");
    System.out.println(sb.get());

    var sc = sa.isEmpty();
    System.out.println(sc.get());
    sa.set("");
    System.out.println(sc.get());

    announce("Integers");
    var ia = new SimpleIntegerProperty(5);
    var ib = new SimpleIntegerProperty(27);

    var ic = ia.add(ib).multiply(ib);   // (a+b)*b
    System.out.println(ic.getValue());

    ia.set(20);
    System.out.println(ic.getValue());

    var id = Bindings.add(ia, ib);  // same as ia.add(ib)
    System.out.println(id.getValue());

    announce("When");
    var description = Bindings.when(ia.lessThan(ib)).then("Less than").otherwise("Greater than or equal to");
    System.out.println(description.get());
    ib.set(0);
    System.out.println(description.get());
  }

  public static void announce(String annoucement) {
    System.out.println("---------------"+annoucement);
  }
}
