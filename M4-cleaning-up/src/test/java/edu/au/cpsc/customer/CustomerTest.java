package edu.au.cpsc.customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void givenNewCustomerThenGettersReturnConstructorArguments() {
    Customer c1 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    assertEquals("Bob", c1.getName());
    assertEquals("bob@foo.net", c1.getEmail());
    assertEquals("724-555-1212", c1.getPhoneNumber());

    Customer c2 = new Customer("Jane", "jane@here.there", "813-123-4567");
    assertEquals("Jane", c2.getName());
    assertEquals("jane@here.there", c2.getEmail());
    assertEquals("813-123-4567", c2.getPhoneNumber());
  }

  @Test
  void givenNewCustomerWhenSettersCalledThenGettersReturnUpdatedValue() {
    // Given
    Customer c = new Customer("Bob", "bob@foo.net", "724-555-1212");

    // When
    c.setName("a");
    c.setEmail("b@foo.net");
    c.setPhoneNumber("813-111-2222");

    // Then
    assertEquals("a", c.getName());
    assertEquals("b@foo.net", c.getEmail());
    assertEquals("813-111-2222", c.getPhoneNumber());
  }

  @Test
  void givenTwoCustomersWithSameFieldsThenEqual() {
    Customer c1 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    Customer c2 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    assertTrue(c1.equals(c2));
    assertTrue(c2.equals(c1));
  }

  @Test
  void givenTwoCustomersWithDifferentNamesThenNotEqual() {
    Customer c1 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    Customer c2 = new Customer("Fred", "bob@foo.net", "724-555-1212");
    assertFalse(c1.equals(c2));
    assertFalse(c2.equals(c1));
  }

  @Test
  void givenTwoCustomersWithDifferentEmailsThenNotEqual() {
    Customer c1 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    Customer c2 = new Customer("Bob", "fred@foo.net", "724-555-1212");
    assertFalse(c1.equals(c2));
    assertFalse(c2.equals(c1));
  }

  @Test
  void givenTwoCustomersWithDifferentPhoneNumbersThenNotEqual() {
    Customer c1 = new Customer("Bob", "bob@foo.net", "724-555-1212");
    Customer c2 = new Customer("Bob", "bob@foo.net", "813-123-4567");
    assertFalse(c1.equals(c2));
    assertFalse(c2.equals(c1));
  }


}