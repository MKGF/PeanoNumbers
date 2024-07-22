package com.desierto;

import lombok.EqualsAndHashCode;

public final class Succ implements Peano {

  final Peano peano;

  Succ(Peano peano) {
    this.peano = peano;
  }
}
