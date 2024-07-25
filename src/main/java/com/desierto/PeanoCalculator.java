package com.desierto;

import static com.desierto.Ordering.EQ;
import static com.desierto.Ordering.GT;
import static com.desierto.Ordering.LT;

public class PeanoCalculator {

  private static final Peano ONE = new Succ(Zero.INSTANCE);

  public static Peano peano(int n) {
    if (0 == n) return Zero.INSTANCE;
    return new Succ(peano(n - 1));
  }

  static Peano add(Peano a, Peano b) {
    if (a instanceof Zero) {
      return b;
    } else if (b instanceof Zero) {
      return a;
    } else {
      Succ aSucc = (Succ) a;
      return recursiveAddition(aSucc, b);
    }
  }

  private static Peano recursiveAddition(Succ a, Peano b) {
    Succ newA;
    if (a.peano instanceof Zero) {
      newA = new Succ(b);
    } else {
      newA = new Succ(recursiveAddition((Succ) a.peano, b));
    }
    return newA;
  }

  /**
   * @throws ArithmeticException if return value is negative
   *
   *
   */
  static Peano sub(Peano a, Peano b) {
    if (a instanceof Zero) {
      if (b instanceof Zero) {
        return Zero.INSTANCE;
      }
      throw new ArithmeticException("return value is negative");
    }
    if (b instanceof Zero) {
      return a;
    }

    return recursiveSubstraction(a, b);
  }

  private static Peano recursiveSubstraction(Peano a, Peano b) {
    if (a instanceof Zero) {
      if (b instanceof Zero) {
        return Zero.INSTANCE;
      }
      throw new ArithmeticException("return value is negative");
    }
    if (b instanceof Zero) {
      return a;
    }
    return recursiveSubstraction(((Succ)a).peano, ((Succ)b).peano);
  }

  static Peano mul(Peano a, Peano b) {
    if (a instanceof Zero || b instanceof Zero) {
      return Zero.INSTANCE;
    }
    return recursiveMultiplication(a, b);
  }

  private static Peano recursiveMultiplication(Peano a, Peano b) {
    if (b instanceof Zero) {
      return Zero.INSTANCE;
    }
    return add(recursiveMultiplication(a, ((Succ)b).peano), a);
  }
  /**
   * @throws ArithmeticException if divided by 0
   *
   *
   */
  static Peano div(Peano a, Peano b) {
    if (b instanceof Zero) {
      throw new ArithmeticException("division by 0");
    }
    if (a instanceof Zero) {
      return Zero.INSTANCE;
    }
    return recursiveDivision(a, b, Zero.INSTANCE, b);
  }

  private static Peano recursiveDivision(Peano a, Peano b, Peano accumulative, Peano newDivision) {
    if (compare(a,newDivision).equals(GT) || compare(a,newDivision).equals(EQ)) {
      return recursiveDivision(a, b, add(accumulative, ONE), add(newDivision, b));
    }
    return accumulative;
  }

  static boolean even(Peano peano) {
    return recursiveParity(peano, true);
  }

  static boolean odd(Peano peano) {
    return recursiveParity(peano, false);
  }

  private static boolean recursiveParity(Peano peano, boolean parity) {
    if (peano instanceof Zero) {
      return parity;
    }
    return recursiveParity(((Succ)peano).peano, !parity);
  }

  static Ordering compare(Peano a, Peano b) {
    if (a instanceof Zero && b instanceof Succ) {
      return LT;
    }
    if (a instanceof Succ && b instanceof Zero) {
      return GT;
    }
    if (a instanceof Zero && b instanceof Zero) {
      return EQ;
    }
    return compare(((Succ) a).peano, ((Succ) b).peano);
  }

}
