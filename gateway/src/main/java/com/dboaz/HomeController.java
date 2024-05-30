package com.dboaz;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.utils.server.abstracts.AbstractController;
import com.dboaz.utils.server.enums.StatusCodeEnum;
import com.dboaz.utils.server.models.Response;
import com.google.gson.Gson;

public class HomeController extends AbstractController {
  private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

  @Override
  public Response get() {
    LOGGER.debug("GET request");

    HomeModel model = new HomeModel("Hello, World Boaz model!");

    return response.builder()
      .status(StatusCodeEnum.OK)
      .header("Custom-Reponse", "Hello custom response")
      .contentType("application/json")
      .body(new Gson().toJson(model))
      .build();
  }
}
