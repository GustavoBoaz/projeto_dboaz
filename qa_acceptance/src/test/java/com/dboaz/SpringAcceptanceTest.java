package com.dboaz;

import java.util.Map;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import io.cucumber.spring.CucumberContextConfiguration;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(
webEnvironment = WebEnvironment.RANDOM_PORT,
classes = {
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

    private static final Map<String, Class<?>> MAP = Map.of(
            "ms_auction", MainAppAuction.class,
            "ms_auth", MainAppAuth.class,
            "ms_bid", MainAppBid.class,
            "ms_comment_rating", MainAppCommentRating.class,
            "ms_logistic", MainAppLogistic.class,
            "ms_messaging", MainAppMessaging.class,
            "ms_notification", MainAppNotification.class,
            "ms_payment", MainAppPayment.class,
            "ms_product", MainAppProduct.class,
            "ms_profile", MainAppProfile.class
    );

    protected Class<?> getClassMap(String nameMicrocervice) {
        return MAP.get(nameMicrocervice);
    }
}
