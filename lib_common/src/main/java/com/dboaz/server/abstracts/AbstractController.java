package com.dboaz.server.abstracts;

import com.dboaz.server.enums.StatusCodeEnum;
import com.dboaz.server.models.Request;
import com.dboaz.server.models.Response;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.google.gson.Gson;

public abstract class AbstractController {
  private static final String METHOD_NOT_IMPLEMENTED = "Method Not Allowed.";
  private static final GenericException ERROR = new GenericException(METHOD_NOT_IMPLEMENTED, SeverityEnum.SEV_001, 405);
  
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
        return this.response.builder()
        .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
        .contentType("application/json")
        .body(new Gson().toJson(ERROR.getMessage()))
        .build();
    }
  }

  public Response get() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response head() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response post() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response put() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response delete() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response connect() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response options() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response trace() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }

  public Response patch() {
    return this.response.builder()
    .status(StatusCodeEnum.METHOD_NOT_ALLOWED)
    .contentType("application/json")
    .body(new Gson().toJson(ERROR.getMessage()))
    .build();
  }
}
