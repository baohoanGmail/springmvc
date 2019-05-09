package com.ntatvr.springmvc.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryNotFoundException extends Exception {

  private static final long serialVersionUID = 8046278152916561126L;

  public EntryNotFoundException(Throwable e) {
    super(e);
  }

  public EntryNotFoundException(Object object) {
    super(object != null ? object.toString() : null);
  }
}
