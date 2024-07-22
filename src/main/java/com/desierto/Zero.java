package com.desierto;

import lombok.EqualsAndHashCode;

final class Zero implements Peano {

  static Zero INSTANCE = new Zero();

  private Zero() {}
}
