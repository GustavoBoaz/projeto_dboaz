package com.dboaz.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.core.DispachModel;
import com.dboaz.server.enums.StatusCodeEnum;
import com.dboaz.server.models.ResponseRoute;
import com.dboaz.server.notations.ParamBody;
import com.dboaz.server.notations.ParamHeader;
import com.dboaz.server.notations.ParamPath;
import com.dboaz.server.notations.ParamQuery;
import com.dboaz.server.notations.Route;
import com.dboaz.server.notations.Router;
import com.google.gson.Gson;

@Router(basePath = "/bff/v1/gateway", nameApiDoc = "DispachAuction")
public class DispachAuction {
    private static final Logger LOGGER = LogManager.getLogger(DispachAuction.class);

    @Route(method = "GET", childPath = "/api/ms_auction", nameApiDoc = "Get Auctions")
    public ResponseRoute getAuctions(
        @ParamQuery(required = false, name = "page", nameApiDoc = "Pagination page") String page,
        @ParamQuery(required = false, name = "size", nameApiDoc = "Pagination size") String size,
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization
    ) {
        LOGGER.info("Dispach Auction");

        DispachModel model = new DispachModel("Mensagem Boaz");

        return new ResponseRoute.Builder()
            .status(StatusCodeEnum.OK)
            .contentType("application/json")
            .addHeader("Authorization", "Bearer BOAZ")
            .addHeader("CustomBoaz", "CustomBoaz")
            .body(new Gson().toJson(model))
            .build();
    }

    @Route(method = "GET", childPath = "/api/ms_auction/{id}", nameApiDoc = "Get Auction")
    public Object getAuction(
        @ParamPath(required = true, name = "id", nameApiDoc = "The id of the auction") String id,
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization
    ) {
        LOGGER.info("Dispach Auction");
        return null;
    }

    @Route(method = "POST", childPath = "/api/ms_auction", nameApiDoc = "Post Auction")
    public Object postAuction(
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization,
        @ParamBody(required = true, nameApiDoc = "The body auction") Object body
    ) {
        LOGGER.info("Dispach Auction");
        return null;
    }

    @Route(method = "PUT", childPath = "/api/ms_auction/{id}", nameApiDoc = "Put Auction")
    public Object putAuction(
        @ParamPath(required = true, name = "id", nameApiDoc = "The id of the auction") String id,
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization,
        @ParamBody(required = true, nameApiDoc = "The body auction") Object body
    ) {
        LOGGER.info("Dispach Auction");
        return null;
    }

    @Route(method = "DELETE", childPath = "/api/ms_auction/{id}", nameApiDoc = "Delete Auction")
    public Object deleteAuction(
        @ParamPath(required = true, name = "id", nameApiDoc = "The id of the auction") String id,
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization
    ) {
        LOGGER.info("Dispach Auction");
        return null;
    }
}
