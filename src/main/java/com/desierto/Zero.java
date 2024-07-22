package com.desierto;

import lombok.EqualsAndHashCode;

public class Zero implements Peano {

  static Zero INSTANCE = new Zero();

  private Zero() {}
}
