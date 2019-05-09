package com.ntatvr.springmvc.exception;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApiData implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4984981421445439339L;

  /** The total. */
  @JsonInclude(Include.NON_NULL)
  private Integer total;

  /** The data. */
  private Object data;

  /**
   * Instantiates a new api data.
   *
   * @param data the data
   */
  public ApiData(Object data) {
    this.data = data;
  }

  /**
   * Instantiates a new api data.
   *
   * @param total the total
   * @param data the data
   */
  public ApiData(Integer total, Object data) {
    this.total = total;
    this.data = data;
  }


}
