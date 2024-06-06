package com.dboaz.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.utils.notations.ParamBody;
import com.dboaz.utils.notations.ParamHeader;
import com.dboaz.utils.notations.ParamPath;
import com.dboaz.utils.notations.ParamQuery;
import com.dboaz.utils.notations.Route;
import com.dboaz.utils.notations.Router;

@Router(basePath = "/bff/v1/gateway", nameApiDoc = "DispachAuction")
public class DispachAuction {
    private static final Logger LOGGER = LogManager.getLogger(DispachAuction.class);

    @Route(method = "GET", childPath = "/api/ms_auction", nameApiDoc = "Get Auctions")
    public Object getAuctions(
        @ParamQuery(required = false, name = "page", nameApiDoc = "Pagination page") Integer page,
        @ParamQuery(required = false, name = "size", nameApiDoc = "Pagination size") Integer size,
        @ParamHeader(required = true, name = "Authorization", nameApiDoc = "The athorization token") String authorization
    ) {
        LOGGER.info("Dispach Auction");
        return null;
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
