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
import com.google.gson.JsonSyntaxException;
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

    parseRequest(convertInputStreamInString(in));
  }

  protected String convertInputStreamInString(InputStream in) {
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
      LOGGER.error(new GenericException("Error in convert inputstrem in string", SeverityEnum.SEV_001, 500));
    }
    return request.toString();
  }

  protected void parseRequest(String inputStream) {
    try (Scanner scanner = new Scanner(inputStream)) {
      // Lê a primeira linha (method, path, protocol)
      String firstLine = scanner.nextLine();
      String[] firstLineParts = firstLine.split("\\s+");
      method = firstLineParts[0];
      String pathWithParams = firstLineParts[1];
      protocol = firstLineParts[2];

      // Extrai os parâmetros de consulta
      int questionMarkIndex = pathWithParams.indexOf('?');
      if (questionMarkIndex != -1) {
        path = pathWithParams.substring(0, questionMarkIndex);
        String paramssString = pathWithParams.substring(questionMarkIndex + 1);
        String[] paramssArray = paramssString.split("&");
        for (String paramsPair : paramssArray) {
          String[] pair = paramsPair.split("=");
          params.put(pair[0], pair[1]);
        }
      } else {
        path = pathWithParams;
      }

      String line;
      while (!(line = scanner.nextLine()).isEmpty()) {
          int colonIndex = line.indexOf(": ");
          if (colonIndex != -1) {
              String headerName = line.substring(0, colonIndex);
              String headerValue = line.substring(colonIndex + 2); // 2 é o comprimento de ": "
              headers.put(headerName, headerValue);
          } else {
              // Lidar com cabeçalhos malformados ou inválidos, se necessário
          }
      }

      // Lê o body
      StringBuilder bodyBuilder = new StringBuilder();
      while (scanner.hasNextLine()) {
        bodyBuilder.append(scanner.nextLine());
      }
      String bodyString = bodyBuilder.toString();

      //valida se tem conteudo no body
      if (bodyString.length() > 0) {
        // Converte o body para um Map
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        body = gson.fromJson(bodyString, type);
      }

    } catch (JsonSyntaxException e) {
      e.printStackTrace();
      LOGGER.error(new GenericException("Json format body error ", SeverityEnum.SEV_004, 400));
    }
  }
}
