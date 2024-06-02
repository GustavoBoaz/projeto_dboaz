package com.dboaz.utils.enums;

import java.util.Map;

public enum SeverityEnum {
  SEV_001("Critical", "System failures causing non-operation or data compromise.", "All users"),
  SEV_002("High", "Critical issues requiring immediate resolution.", "Most users"),
  SEV_003("Medium", "Issues affecting some features but system remains operational.", "Some users"),
  SEV_004("Low", "Minor issues not affecting main functionality.", "One user");

  private final String severity;
  private final String description;
  private final String userImpact;

  SeverityEnum(String severity, String description, String userImpact) {
    this.severity = severity;
    this.description = description;
    this.userImpact = userImpact;
  }

  public String getSeverity() {
    return severity;
  }

  public String getDescription() {
    return description;
  }

  public String getUserImpact() {
    return userImpact;
  }

  @Override
  public String toString() {
    return String.format("Severity: %s, Description: %s, User Impact: %s", severity, description, userImpact);
  }

  public Map<String, String> toJson() {
    return Map.of("severity", severity, "description", description, "userImpact", userImpact);
  }
}
