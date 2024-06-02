package com.dboaz;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.SelectClasspathResources;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResources({
  @SelectClasspathResource("features"),
  @SelectClasspathResource("features/ms_auction"),
  @SelectClasspathResource("features/ms_auth"),
  @SelectClasspathResource("features/ms_bid"),
  @SelectClasspathResource("features/ms_comment_rating"),
  @SelectClasspathResource("features/ms_logistic"),
  @SelectClasspathResource("features/ms_messaging"),
  @SelectClasspathResource("features/ms_notification"),
  @SelectClasspathResource("features/ms_payment"),
  @SelectClasspathResource("features/ms_product"),
  @SelectClasspathResource("features/ms_profile")
})
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/cucumber/cucumber-report.html, pretty")
public class RunAcceptanceTest {
  
}
