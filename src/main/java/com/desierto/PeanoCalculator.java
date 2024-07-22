package com.desierto;

public class PeanoCalculator {

  static Peano add(Peano a, Peano b) {
    return a;
  }

  /**
   * @throws ArithmeticException if return value is negative
   *
   *
   */
  static Peano sub(Peano a, Peano b) {
    return a;
  }

  static Peano mul(Peano a, Peano b) {
    return a;
  }

  /**
   * @throws ArithmeticException if divided by 0
   *
   *
   */
  static Peano div(Peano a, Peano b) {
    return a;
  }

  static boolean even(Peano peano) {
    return true;
  }

  static boolean odd(Peano peano) {
    return true;
  }

  static Ordering compare(Peano a, Peano b) {
    return Ordering.EQ;
  }

}
