package com.dboaz.ms_auction;

import com.dboaz.ms_auction.utils.constants.Route;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class DocInfoSimulation extends Simulation {
    

    ChainBuilder info = exec(
        http("InfoApi").get(Route.GET_INFO)
    );

    HttpProtocolBuilder httpProtocol =
        http.baseUrl("http://localhost:8080");

    ScenarioBuilder dev = scenario("Dev access info api").exec(info);

    {
        setUp(
            dev.injectClosed(
                constantConcurrentUsers(1).during(1)
            )
        ).protocols(httpProtocol);
    }
}
