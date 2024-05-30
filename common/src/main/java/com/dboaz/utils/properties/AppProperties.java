package com.dboaz.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public class AppProperties {
  private static final Logger LOGGER = LogManager.getLogger(AppProperties.class);

  public static Properties contextMain() {
    Properties prop = new Properties();
    try (InputStream input = AppProperties.class.getResourceAsStream("/application.properties")) {
      prop.load(input);
    } catch (IOException error) {
      LOGGER.error(new GenericException("Error: [read file in context main]".concat(error.getMessage()), SeverityEnum.SEV_001, 500));
    }
    return prop;
  }

  public static Properties contextTest() {
    Properties prop = new Properties();
    try (InputStream input = AppProperties.class.getResourceAsStream("/application-test.properties")) {
      prop.load(input);
    } catch (IOException error) {
      LOGGER.error(new GenericException("Error: [read file in context test]".concat(error.getMessage()), SeverityEnum.SEV_001, 500));
    }
    return prop;
  }
}
