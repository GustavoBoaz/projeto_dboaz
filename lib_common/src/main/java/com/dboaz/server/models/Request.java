package com.dboaz.server.models;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Request {
  private static final Logger LOGGER = LogManager.getLogger(Request.class);

  private static final int BUFFER_SIZE = 65536; //4096

  public String method;
  public String path;
  public String protocol;
  public Map<String, String> params;
  public Map<String, String> headers;
  public Map<Comparable<Object>, Object> body;

  public Request(InputStream in) {
    this.params = new HashMap<>();
    this.headers = new HashMap<>();
    this.body = new HashMap<>();

    fillRequest(parseString(in));
  }

  /**
   * parseString
   * 
   * @param in - input stream format protocol http request
   * @return string representation of the request
   */
  protected String parseString(InputStream in) {
    byte[] buffer = new byte[BUFFER_SIZE];
    int bytesRead;
    StringBuilder request = new StringBuilder();
    try {
      while ((bytesRead = in.read(buffer)) != -1) {
        request.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
        if (request.toString().contains("\r\n\r\n")) {
          break;
        }
      }
    } catch (IOException e) {
      LOGGER.error(new GenericException("[ Convert inputstrem in string ]: ".concat(e.getMessage()), SeverityEnum.SEV_001, 500));
    }
    return request.toString();
  }

  /**
   * fillRequest
   * 
   * @param inputStream - String input stream
   */
  protected void fillRequest(String inputStream) {
    try (Scanner scanner = new Scanner(inputStream)) {
      fillFirstLine(scanner);
      fillHeaderLines(scanner);
      fillBody(scanner);
    } catch (Exception e) {
      LOGGER.error(new GenericException("[ Fill request invalid ]: ".concat(e.getMessage()), SeverityEnum.SEV_004, 500));
    }
  }

  /**
   * fillFirstLine
   * 
   * @param scanner - First reading
   */
  protected void fillFirstLine(Scanner scanner) {
    String scannerFirstLine = scanner.nextLine();
    String[] firstLineParts = scannerFirstLine.split("\\s+");
    fillMethod(firstLineParts[0]);
    fillPathAndParams(firstLineParts[1]);
    fillProtocol(firstLineParts[2]);
  }

  /**
   * fillHeaderLines
   * 
   * @param scanner - Second reading
   */
  protected void fillHeaderLines(Scanner scanner) {
    String line;
    while (!(line = scanner.nextLine()).isEmpty()) {
      int colonIndex = line.indexOf(": ");
      if (colonIndex != -1) {
        String headerName = line.substring(0, colonIndex);
        String headerValue = line.substring(colonIndex + 2);
        headers.put(headerName, headerValue);
      } else {
        LOGGER.error(new GenericException("[ Poorly formatted header ]: valid format is 'key': 'value' format", SeverityEnum.SEV_004, 400));
      }
    }
  }

  /**
   * fillBody
   * 
   * @param scanner - Third reading
   */
  protected void fillBody(Scanner scanner) {
    StringBuilder bodyBuilder = new StringBuilder();
    String bodyString = bodyBuilder.toString();

    // Read body
    while (scanner.hasNextLine()) {
      bodyBuilder.append(scanner.nextLine());
    }

    // Check if body exists
    if (bodyString.length() > 0) {
      // Convert body to map
      Gson gson = new Gson();
      Type type = new TypeToken<Map<String, Object>>() {}.getType();
      body = gson.fromJson(bodyString, type);
    }
  }

  /**
   * fillMethod
   * 
   * @param firstLineParts0 - String ex.: GET
   */
  protected void fillMethod(String firstLinePart0) {
    this.method = firstLinePart0;
  }

  /**
   * fillPathAndParams
   * 
   * @param firstLineParts1 - String ex.: /api/v1/auction?page=1&size=100
   */
  protected void fillPathAndParams(String firstLinePart1) {
    int questionMarkIndex = firstLinePart1.indexOf('?');
    if (questionMarkIndex != -1) {
      path = firstLinePart1.substring(0, questionMarkIndex);
      String paramssString = firstLinePart1.substring(questionMarkIndex + 1);
      String[] paramssArray = paramssString.split("&");
      for (String paramsPair : paramssArray) {
        String[] pair = paramsPair.split("=");
        params.put(pair[0], pair[1]);
      }
    } else {
      path = firstLinePart1;
    }
  }

  /**
   * fillProtocol
   * 
   * @param firstLineParts2 - String ex.: HTTP/1.1
   */
  protected void fillProtocol(String firstLinePart2) {
    protocol = firstLinePart2;
  }
}
