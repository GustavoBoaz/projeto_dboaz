package com.dboaz.server.abstracts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dboaz.server.interfaces.MiddlewareImpl;
import com.dboaz.server.models.Request;
import com.dboaz.server.models.Response;
import com.dboaz.server.models.Route;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public abstract class AbstractServerUtil {
  private Route routes;
  private Map<String, Class<? extends AbstractController>> controllers;
  private Map<String, Set<MiddlewareImpl>> middlewares;

  protected AbstractServerUtil() {
    this.routes = new Route();
    this.controllers = new HashMap<>();
    this.middlewares = new HashMap<>();
  }

  public void addRoute(String baseRoute, String childRoute, Class<? extends AbstractController> controller, Set<MiddlewareImpl> middlewares) {
    routes.addRoute(baseRoute, childRoute);
    addController(baseRoute.concat(childRoute), controller);

    if (middlewares != null) {
      for (MiddlewareImpl middleware : middlewares) {
        addMiddleware(baseRoute.concat(childRoute), middleware);
      }
    }
  }

  public void addRoute(String baseRoute, String childRoute, Class<? extends AbstractController> controller) {
    routes.addRoute(baseRoute, childRoute);
    addController(baseRoute.concat(childRoute), controller);
  }

  protected Response executeController(Request request, Response response) {
    Class<? extends AbstractController> controllerClass = controllers.get(request.path);
    AbstractController controller;

    try {
      if (controllerClass != null) {
        controller = controllerClass.getDeclaredConstructor().newInstance();
      } else {
        return response;
      }
    } catch (Exception e) {
      throw new GenericException("[ Creating controller instance ]: ".concat(e.getMessage()), SeverityEnum.SEV_001, 500);
    }
    return controller.execute(request, response);
  }

  protected Boolean executeMiddlewares(Request request, Response response) {
    if (!middlewares.isEmpty()) {
      Set<MiddlewareImpl> requestMiddlewares = this.middlewares.get(request.path);
      for (MiddlewareImpl middleware : requestMiddlewares) {
        middleware.intercept(request, response);
        if (!middleware.isAuthorized()) {
          return false;
        }
      }
      return true;
    }
    return true;
  }

  private void addController(String route, Class<? extends AbstractController> controller) {
    if (existRouteController(route)) {
      throw new GenericException("Error [ Add controller error ]: Route already exists", SeverityEnum.SEV_001, 500);
    } else {
      this.controllers.put(route, controller);
    }
  }

  private void addMiddleware(String route, MiddlewareImpl middleware) {
    if (existRouteMiddlewares(route)) {
      if (existMiddleware(route, middleware)) {
        throw new GenericException("Error [ Add middleware error ]: Middleware already exists", SeverityEnum.SEV_001, 500);
      }
      middlewares.get(route).add(middleware);
    } else {
      Set<MiddlewareImpl> newMiddlewares = new HashSet<>();
      newMiddlewares.add(middleware);
      this.middlewares.put(route, newMiddlewares);
    }
  }

  private Boolean existRouteController(String route) {
    return controllers.containsKey(route);
  }

  private Boolean existRouteMiddlewares(String route) {
    return middlewares.containsKey(route);
  }

  private Boolean existMiddleware(String route, MiddlewareImpl middleware) {
    return middlewares.get(route).contains(middleware);
  }
}
