package com.ntatvr.springmvc.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContentNotAllowedException extends Exception {

  private static final long serialVersionUID = 1556587568709120812L;

  public ContentNotAllowedException(Throwable e) {
    super(e);
  }

  public ContentNotAllowedException(Object object) {
    super(object != null ? object.toString() : null);
  }
}
