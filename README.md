# PeanoNumbers

Peano numbers are a simple way of representing the natural numbers using only a zero value and a successor function. We can represent Peano numbers as follows:

```
interface Peano {
  final class Zero implements Peano {
    static Zero INSTANCE = new Zero();
    private Zero() {}
  }

  final class Succ implements Peano {
    final Peano peano;
    Succ(Peano peano) {
      this.peano = peano;
    }
  }
}
```

where:

- 0 is represented by Zero.INSTANCE
- 1 is represented by Succ(Zero.INSTANCE)
- 2 is represented by Succ(Succ(Zero.INSTANCE))
- 3 is represented by Succ(Succ(Succ(Zero.INSTANCE)))

etc.
Your mission in this Kata is to implement the following static operations with peano numbers:

- add(Peano a, Peano b) Addition
- sub(Peano a, Peano b) Subtract (ArithmeticException: "negative number")
- mul(Peano a, Peano b) Multiplication
- div(Peano a, Peano b) Integer division (ArithmeticException: "divide by 0")
- even(Peano a) Even number
- odd(Peano a) Odd number
- compare(Peano a, Peano b) Compare (LT, GT or EQ)
