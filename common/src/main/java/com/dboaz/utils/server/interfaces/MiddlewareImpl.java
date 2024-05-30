package com.dboaz.utils.server.interfaces;

import com.dboaz.utils.server.models.Request;
import com.dboaz.utils.server.models.Response;

public interface MiddlewareImpl {
  Boolean AUTHORIZED = true;
  Boolean UNAUTHORIZED = false;

  void intercept(Request request, Response response);
  Boolean isAuthorized();
}
