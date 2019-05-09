package com.ntatvr.springmvc.utils;

import java.util.Properties;

public class Constants {

  /** The Constant SLASH. */
  public static final String SLASH = "/";

  /** The Constant CONFIG_PROPS. */
  public static final Properties CONFIG_PROPS = FileUtils.getMessageProperties();

  public static final String ERROR_DOES_NOT_EXIST =
      CONFIG_PROPS.getProperty("response.get.error.does-not-exist");

  public static final String ERROR_FAILED_TO_DELETE =
      CONFIG_PROPS.getProperty("response.get.error.failed-to-delete");
  
  public static final String ERROR_LOAD_CANCELED =
      CONFIG_PROPS.getProperty("response.get.error.load-canceled");
  
  public static final String MESSAGE_DELETE_SUCCESSFUL =
      CONFIG_PROPS.getProperty("response.get.success.delete-successful");
  
  public static final String MESSAGE_SAVE_SUCCESSFUL =
      CONFIG_PROPS.getProperty("response.get.success.save-successful");
  
}
