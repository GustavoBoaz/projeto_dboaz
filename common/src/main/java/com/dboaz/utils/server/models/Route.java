package com.dboaz.utils.server.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public class Route {
  private Map<String, Set<String>> routes;

  public Route() {
    this.routes = new HashMap<>();
  }

  public void addRoute(String baseRoute, String childRoute) {
    if (routes.containsKey(baseRoute)) {
      if (routes.get(baseRoute).contains(childRoute)) {
        throw new GenericException("Error [create route error]: Route already exists", SeverityEnum.SEV_001, 500);
      }
      routes.get(baseRoute).add(childRoute);
    } else {
      Set<String> childRoutes = new HashSet<>();
      childRoutes.add(childRoute);
      routes.put(baseRoute, childRoutes);
    }
  }
}
