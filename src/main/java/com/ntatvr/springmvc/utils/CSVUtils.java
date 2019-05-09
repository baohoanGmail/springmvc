package com.ntatvr.springmvc.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class CSVUtils {

  private static final char DEFAULT_SEPARATOR = ',';
  private static final char SPACE = ' ';

  public CSVUtils() {}

  /**
   * Write line.
   *
   * @param writer {@link Writer}
   * @param values the values
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void writeLine(Writer writer, List<String> values) throws IOException {
    writeLine(writer, values, DEFAULT_SEPARATOR, SPACE);
  }

  /**
   * Write line.
   *
   * @param writer {@link Writer}
   * @param values the values
   * @param separators the separators
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void writeLine(Writer writer, List<String> values, char separators)
      throws IOException {
    writeLine(writer, values, separators, '"');
  }

  /**
   * Follow CV sformat.
   *
   * @param value the value
   * @return the string
   */
  public static String followCVSformat(String value) {

    String result = value;
    if (StringUtils.isBlank(result)) {
      result = StringUtils.EMPTY;
    } else {
      if (result.contains("\"")) {
        result = result.replace("\"", "\"\"");
      }
    }

    return result;

  }

  /**
   * Write line.
   *
   * @param writer {@link Writer}
   * @param values {@link List}
   * @param separators a char
   * @param customQuote a char
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void writeLine(Writer writer, List<String> values, char separators,
      char customQuote) throws IOException {

    boolean first = true;

    if (separators == SPACE) {
      separators = DEFAULT_SEPARATOR;
    }

    StringBuilder sb = new StringBuilder();

    for (String value : values) {

      if (!first) {
        sb.append(separators);
      }

      if (customQuote == SPACE) {
        sb.append(followCVSformat(value));
      } else {
        sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
      }

      first = false;
    }

    sb.append("\n");
    writer.append(sb.toString());
  }
}
