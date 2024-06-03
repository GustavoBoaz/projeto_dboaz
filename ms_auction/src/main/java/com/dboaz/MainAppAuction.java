package com.dboaz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.app.DBoazApp;
import com.dboaz.properties.ApplicationProperties;
import com.dboaz.utils.notations.DBoazBootApp;
import com.dboaz.utils.notations.DBoazBootServer;

@DBoazBootApp(name = "MS-Auction", date = "2024/06/01", version = "00.00.001-version", release = "01.00.000-release")
@DBoazBootServer(port = "8080")
public class MainAppAuction {
    private static final Logger LOGGER = LogManager.getLogger(MainAppAuction.class);
    private static final String ENVIROMENT = ApplicationProperties.main("enviroment");

    public static void main(String[] args) {
        LOGGER.info("| Auction [ env: {} ] |", ENVIROMENT);
        var server = DBoazApp.run(MainAppAuction.class, args).server();

        server.start();
    }
}
