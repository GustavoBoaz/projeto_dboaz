package com.dboaz.server.abstracts;

import com.dboaz.server.models.Request;
import com.dboaz.server.models.Response;

public abstract class AbstractController {
  private static final String METHOD_NOT_IMPLEMENTED = "Method not implemented.";
  
  protected Request request;
  protected Response response;

  Response execute(Request request, Response response) {
    this.request = request;
    this.response = response;

    switch (request.method) {
      case "GET":
        return get();
      case "HEAD":
        return head();
      case "POST":
        return post();
      case "PUT":
        return put();
      case "DELETE":
        return delete();
      case "CONNECT":
        return connect();
      case "OPTIONS":
        return options();
      case "TRACE":
        return trace();
      case "PATCH":
        return patch();
      default:
        throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
    }
  }

  public Response get() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response head() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response post() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response put() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response delete() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response connect() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response options() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response trace() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  public Response patch() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }
}
