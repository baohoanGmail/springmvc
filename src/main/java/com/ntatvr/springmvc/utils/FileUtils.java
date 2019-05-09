package com.ntatvr.springmvc.utils;

import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

  /**
   * Get properties from message properties file.
   *
   * @return the properties
   */
  public static Properties getMessageProperties() {

    Properties props = new Properties();
    InputStream in = FileUtils.class.getResourceAsStream("/message.properties");
    try {
      props.load(in);
    } catch (Exception e) {
      return null;
    }
    return props;
  }
}
