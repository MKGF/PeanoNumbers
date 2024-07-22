package com.desierto;

import lombok.EqualsAndHashCode;

final class Succ implements Peano {

  final Peano peano;

  Succ(Peano peano) {
    this.peano = peano;
  }
}
