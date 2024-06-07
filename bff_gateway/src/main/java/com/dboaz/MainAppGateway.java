package com.dboaz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.app.DBoazApp;
import com.dboaz.properties.ApplicationProperties;
import com.dboaz.resources.DispachAuction;
import com.dboaz.utils.notations.DBoazBootApp;
import com.dboaz.utils.notations.DBoazBootServer;

@DBoazBootApp(name = "BFF-Gateway", date = "2024/06/01", version = "00.00.001-version", release = "01.00.000-release")
@DBoazBootServer(port = "8080")
public class MainAppGateway {
  private static final Logger LOGGER = LogManager.getLogger(MainAppGateway.class);
  private static final String ENVIROMENT = ApplicationProperties.main("enviroment");

  public static void main(String[] args) {
    LOGGER.info("[ Gateway ENV: {} ]", ENVIROMENT);
    var app = DBoazApp.run(MainAppGateway.class, args);

    app.server.addRoute(DispachAuction.class);

    app.server.start();
  }
}
