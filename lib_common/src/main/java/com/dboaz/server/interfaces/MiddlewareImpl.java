package com.dboaz.server.interfaces;

import com.dboaz.server.models.Request;
import com.dboaz.server.models.Response;

public interface MiddlewareImpl {
  Boolean AUTHORIZED = true;
  Boolean UNAUTHORIZED = false;

  void intercept(Request request, Response response);
  Boolean isAuthorized();
}
