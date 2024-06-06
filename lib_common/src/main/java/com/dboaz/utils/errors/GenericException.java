package com.dboaz.utils.errors;

import com.dboaz.utils.enums.SeverityEnum;

public class GenericException extends RuntimeException {
  private final SeverityEnum severity;
  private final Integer statusResponse;

  public GenericException(String message, SeverityEnum severity, Integer statusResponse) {
    super(concatMessage(message, severity, statusResponse));
    this.severity = severity;
    this.statusResponse = statusResponse;
  }

  private static String concatMessage(String message, SeverityEnum severity, Integer statusResponse) {
    return String.format("Message: [%s] Severity: [%s] Status: [%s]", message, severity.getSeverity(),
        statusResponse.toString());
  }

  public SeverityEnum getSeverity() {
    return severity;
  }

  public Integer getStatusResponse() {
    return statusResponse;
  }
}
