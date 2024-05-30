package com.dboaz;

import com.dboaz.utils.server.Server;

import static com.dboaz.utils.properties.AppProperties.contextMain;

public class MainAppGateway {
  private static final String SERVER_PORT = contextMain().getProperty("server.port");

  public static void main(String[] args) {

    Server server = new Server(Integer.parseInt(SERVER_PORT));

    server.addRoute("/api/v1", "/home", HomeController.class);

    server.start();

  }
}
