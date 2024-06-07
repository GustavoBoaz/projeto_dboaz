package com.dboaz.server.models;

import java.util.ArrayList;
import java.util.List;

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
}
