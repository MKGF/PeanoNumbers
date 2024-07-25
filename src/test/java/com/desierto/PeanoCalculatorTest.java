package com.desierto;

import static com.desierto.Ordering.EQ;
import static com.desierto.Ordering.GT;
import static com.desierto.Ordering.LT;
import static com.desierto.PeanoCalculator.add;
import static com.desierto.PeanoCalculator.compare;
import static com.desierto.PeanoCalculator.div;
import static com.desierto.PeanoCalculator.even;
import static com.desierto.PeanoCalculator.mul;
import static com.desierto.PeanoCalculator.odd;
import static com.desierto.PeanoCalculator.peano;
import static com.desierto.PeanoCalculator.sub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PeanoCalculatorTest {

  private static void assertPeanoEq(Peano a, Peano b) {
    assertEquals(EQ, compare(a, b));
  }

  private static void assertPeano(Peano a, Peano b, Ordering ordering) {
    assertEquals(ordering, compare(a, b));
  }

  @Test
  public void addTest() throws Exception {
    assertPeanoEq(peano(0), add(peano(0), peano(0)));
    assertPeanoEq(peano(664), add(peano(0), peano(664)));
    assertPeanoEq(peano(5), add(peano(3), peano(2)));
    assertPeanoEq(peano(761), add(peano(537), peano(224)));
  }

  @Test
  public void subTest() throws Exception {
    assertPeanoEq(peano(0), sub(peano(0), peano(0)));
    assertPeanoEq(peano(10), sub(peano(10), peano(0)));
    assertPeanoEq(peano(1), sub(peano(3), peano(2)));
    assertPeanoEq(peano(313), sub(peano(537), peano(224)));
    assertPeanoEq(peano(0), sub(peano(99), peano(99)));
    assertThrows(ArithmeticException.class, () -> sub(peano(0), peano(1)));
    assertThrows(ArithmeticException.class, () -> sub(peano(5), peano(7)));
  }

  @Test
  public void mulTest() throws Exception {
    assertPeanoEq(peano(0), mul(peano(0), peano(0)));
    assertPeanoEq(peano(0), mul(peano(5), peano(0)));
    assertPeanoEq(peano(35), mul(peano(7), peano(5)));
    assertPeanoEq(peano(744), mul(peano(31), peano(24)));
  }

  @Test
  public void divTest() throws Exception {
    assertPeanoEq(peano(4), div(peano(8), peano(2)));
    assertPeanoEq(peano(3), div(peano(10), peano(3)));
    assertPeanoEq(peano(7), div(peano(123), peano(16)));
    assertPeanoEq(peano(0), div(peano(0), peano(16)));
    assertThrows(ArithmeticException.class, () -> div(peano(5), peano(0)));
    assertThrows(ArithmeticException.class, () -> div(peano(0), peano(0)));
  }

  @Test
  public void evenTest() throws Exception {
    assertTrue(even(peano(0)));
    assertTrue(even(peano(8)));
    assertFalse(even(peano(57)));
    assertFalse(even(peano(123)));
  }

  @Test
  public void oddTest() throws Exception {
    assertFalse(odd(peano(0)));
    assertFalse(odd(peano(8)));
    assertTrue(odd(peano(57)));
    assertTrue(odd(peano(123)));
  }

  @Test
  public void compareTest() throws Exception {
    assertEquals(LT, compare(peano(0), peano(4)));
    assertEquals(GT, compare(peano(210), peano(43)));
    assertEquals(EQ, compare(peano(0), peano(0)));
  }
}
