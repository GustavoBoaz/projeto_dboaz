package com.dboaz.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

/**
 * ApplicationProperties
 * <p>
 *  This class provide access to application.properties and application-test.properties files
 * </P
 * 
 * @author GustavoBoaz
 */
public class ApplicationProperties {
  private static final Logger LOGGER = LogManager.getLogger(ApplicationProperties.class);

  /**
   * main
   * <p>
   *  Access application.properties in main context
   * </p>
   * 
   * @param propertie - String propertie. ex: "enviroment.dev"
   * @return String value propertie
   */
  public static String main(String propertie) {
    Properties prop = new Properties();
    try (InputStream input = ApplicationProperties.class.getResourceAsStream("/application.properties")) {
      prop.load(input);
    } catch (IOException error) {
      LOGGER.error(new GenericException("[ Read file in context main ]: ".concat(error.getMessage()), SeverityEnum.SEV_001, 500));
    }
    return prop.getProperty(propertie);
  }

  /**
   * test
   * <p>
   *  Access application-test.properties in test context
   * </p>
   * 
   * @param propertie - String propertie. ex: "enviroment.dev"
   * @return String value propertie
   */
  public static String test(String propertie) {
    Properties prop = new Properties();
    try (InputStream input = ApplicationProperties.class.getResourceAsStream("/application-test.properties")) {
      prop.load(input);
    } catch (IOException error) {
      LOGGER.error(new GenericException("[ Read file in context test ]: ".concat(error.getMessage()), SeverityEnum.SEV_001, 500));
    }
    return prop.getProperty(propertie);
  }
}
