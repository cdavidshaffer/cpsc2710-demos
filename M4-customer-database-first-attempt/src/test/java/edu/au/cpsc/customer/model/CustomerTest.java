package edu.au.cpsc.customer.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void givenANewCustomerThenGettersReturnCorrectValues() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    assertEquals("Fred", fred.getName());
    assertEquals("abc@def.net", fred.getEmail());
    assertEquals("724-555-1212", fred.getPhoneNumber());
    Customer wilma = new Customer("Wilma", "wilma@foo.com", "724-123-4567");
    assertEquals("Wilma", wilma.getName());
    assertEquals("wilma@foo.com", wilma.getEmail());
    assertEquals("724-123-4567", wilma.getPhoneNumber());
  }

  @Test
  void givenTwoCustomersWithSamePropertiesThenEqual() {
    Customer fred1 = new Customer("Fred", "abc@def.net", "724-555-1212");
    Customer fred2 = new Customer("Fred", "abc@def.net", "724-555-1212");
    assertTrue(fred1.equals(fred2));
    assertTrue(fred2.equals(fred1));
  }

  @Test
  void givenTwoCustomersWithDifferingNameThenNotEqual() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    Customer barney = new Customer("Barney", "abc@def.net", "724-555-1212");
    assertFalse(fred.equals(barney));
    assertFalse(barney.equals(fred));
  }

  @Test
  void givenTwoCustomersWithDifferingEmailThenNotEqual() {
    Customer fred1 = new Customer("Fred", "abc@def.net", "724-555-1212");
    Customer fred2 = new Customer("Fred", "abc@def.com", "724-555-1212");
    assertFalse(fred1.equals(fred2));
    assertFalse(fred2.equals(fred1));
  }

  @Test
  void givenTwoCustomersWithDifferingPhoneThenNotEqual() {
    Customer fred1 = new Customer("Fred", "abc@def.net", "724-555-1212");
    Customer fred2 = new Customer("Fred", "abc@def.net", "724-123-4567");
    assertFalse(fred1.equals(fred2));
    assertFalse(fred2.equals(fred1));
  }

  @Test
  void givenSameCustomerThenEqual() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    assertTrue(fred.equals(fred));
  }

  @Test
  void givenCustomerWhenEqualsWithWrongTypeThenNotEqual() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    assertFalse(fred.equals("Fred"));
  }

  @Test
  void givenCustomerWhenEqualsWithNullThenNotEqual() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    assertFalse(fred.equals(null));
  }

  @Test
  void givenCustomerWhenSettersCalledThenGettersGiveUpdatedValues() {
    Customer fred = new Customer("Fred", "abc@def.net", "724-555-1212");
    fred.setName("a");
    fred.setEmail("b@foo.net");
    fred.setPhoneNumber("814-123-4567");
    assertEquals("a", fred.getName());
    assertEquals("b@foo.net", fred.getEmail());
    assertEquals("814-123-4567", fred.getPhoneNumber());
  }
}