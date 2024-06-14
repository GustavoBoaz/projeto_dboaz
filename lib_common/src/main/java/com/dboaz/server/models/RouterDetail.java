package com.dboaz.server.models;

import java.util.ArrayList;
import java.util.List;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public class RouterDetail {
    private String basePath;
    private List<RouteDetail> routes;

    public RouterDetail(String basePath) {
        this.basePath = basePath;
        this.routes = new ArrayList<>();
    }

    public String getBasePath() {
        return basePath;
    }

    public List<RouteDetail> getRoutes() {
        return routes;
    }

    public void addRoute(RouteDetail route) {
        this.routes.add(route);
    }

    public RouteDetail searchRouteByVerbMethodAndFullPath(String verbMethod, String fullPath) {
        for (RouteDetail route : routes) {
            if (route.getVerbMethod().equals(verbMethod) && route.getFullPath().equals(fullPath)) {
                return route;
            }
        }
        throw new GenericException("Error [ RouterReflection ]: Router {} not found".concat(fullPath), SeverityEnum.SEV_004, 404);
    }
}
