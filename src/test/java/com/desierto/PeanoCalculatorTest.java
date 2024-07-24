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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PeanoCalculatorTest {

  private static void assertPeanoEq(Peano a, Peano b) {
    assertEquals(EQ, compare(a, b));
  }

  @Test
  public void addTest() throws Exception {
    assertPeanoEq(peano(0), add(peano(0), peano(0)));
    assertPeanoEq(peano(664), add(peano(0), peano(664)));
  }

  @Test
  public void subTest() throws Exception {
    assertPeanoEq(peano(0), sub(peano(0), peano(0)));
    assertPeanoEq(peano(10), sub(peano(10), peano(0)));
  }

  @Test
  public void mulTest() throws Exception {
    assertPeanoEq(peano(0), mul(peano(0), peano(0)));
    assertPeanoEq(peano(0), mul(peano(5), peano(0)));
  }

  @Test
  public void divTest() throws Exception {
    assertPeanoEq(peano(4), div(peano(8), peano(2)));
    assertPeanoEq(peano(3), div(peano(10), peano(3)));
  }

  @Test
  public void evenTest() throws Exception {
    assertTrue(even(peano(0)));
    assertTrue(even(peano(8)));
  }

  @Test
  public void oddTest() throws Exception {
    assertFalse(odd(peano(0)));
    assertFalse(odd(peano(8)));
  }

  @Test
  public void compareTest() throws Exception {
    assertEquals(LT, compare(peano(0), peano(4)));
    assertEquals(GT, compare(peano(210), peano(43)));
    assertEquals(EQ, compare(peano(0), peano(0)));
  }
}
