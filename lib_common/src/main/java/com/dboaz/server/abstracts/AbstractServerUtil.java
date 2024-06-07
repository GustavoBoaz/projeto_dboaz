package com.dboaz.server.abstracts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dboaz.server.interfaces.MiddlewareImpl;
import com.dboaz.server.models.*;
import com.dboaz.server.reflections.RouterReflection;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public abstract class AbstractServerUtil {
  private RouterReflection reflection;

  protected AbstractServerUtil() {
    this.reflection = new RouterReflection();
  }

  public void addRoute(Class<?> routerClass) {
    reflection.registerRouter(routerClass);
  }

  protected Response executeRouter(Request request, Response response) {
    return reflection.invokeMethod(request, response);
  }
}
