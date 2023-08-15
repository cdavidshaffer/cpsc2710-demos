package edu.au.cpsc.observabledemo;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * An Observable integer.  This is not the kind of class that you would normally create but it
 * it is helpful to see an example of something that implements ObservableValue.
 */
public class ObservableInteger implements ObservableValue<Integer> {

  @Override
  public void addListener(ChangeListener<? super Integer> changeListener) {

  }

  @Override
  public void removeListener(ChangeListener<? super Integer> changeListener) {

  }

  @Override
  public Integer getValue() {
    IntegerProperty i = null;
    return null;
  }

  @Override
  public void addListener(InvalidationListener invalidationListener) {

  }

  @Override
  public void removeListener(InvalidationListener invalidationListener) {

  }
}
