package com.dboaz;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {
    MainAppGateway.class,
    MainAppBid.class,
    MainAppAuth.class,
    MainAppAuction.class,
    MainAppPayment.class,
    MainAppProduct.class,
    MainAppProfile.class,
    MainAppLogistic.class,
    MainAppMessaging.class,
    MainAppNotification.class,
    MainAppCommentRating.class
})
public class SpringAcceptanceTest {

}
