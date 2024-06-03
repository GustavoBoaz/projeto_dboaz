package com.dboaz.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.core.DispachModel;
import com.dboaz.server.abstracts.AbstractController;
import com.dboaz.server.enums.StatusCodeEnum;
import com.dboaz.server.models.Response;
import com.google.gson.Gson;

public class DispachAuction extends AbstractController {
    private static final Logger LOGGER = LogManager.getLogger(DispachAuction.class);

    @Override
    public Response get() {
        LOGGER.info("Dispach Auction");

        // CALL DISPACH Auction
        DispachModel model = new DispachModel("Dispach in Auction service");

        return response.builder()
            .status(StatusCodeEnum.OK)
            .header("Custom-Response", "Hello Boaz Custom Response")
            .contentType("application/json")
            .body(new Gson().toJson(model))
            .build();
    }
    
}
