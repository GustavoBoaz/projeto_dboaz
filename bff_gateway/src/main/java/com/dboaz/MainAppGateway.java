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
  private static final String BASE_ROUTE = ApplicationProperties.main("base.route.v1");
  private static final String CHILD_ROUTE_MS_AUCTION = ApplicationProperties.main("child.route.ms_auction");

  public static void main(String[] args) {
    LOGGER.info("| Gateway [ env: {} ] |", ENVIROMENT);
    var server = DBoazApp.run(MainAppGateway.class, args).server();

    server.addRoute(BASE_ROUTE, CHILD_ROUTE_MS_AUCTION, DispachAuction.class);

    server.start();
  }
}
