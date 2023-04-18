package com.rivet.api.resources.common.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public final class EmptyObject {
  private int _cachedHashCode;

  EmptyObject() {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmptyObject;
  }

  @Override
  public String toString() {
    return "EmptyObject{" + "}";
  }
}
