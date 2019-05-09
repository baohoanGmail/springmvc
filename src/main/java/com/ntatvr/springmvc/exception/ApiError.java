package com.ntatvr.springmvc.exception;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError implements Serializable {

  private static final long serialVersionUID = -4984981421445439339L;

  private Object errors;

}
