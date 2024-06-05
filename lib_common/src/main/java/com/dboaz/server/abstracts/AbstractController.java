package com.dboaz.server.abstracts;

import com.dboaz.server.models.Request;
import com.dboaz.server.models.Response;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public abstract class AbstractController {
  private static final String METHOD_NOT_IMPLEMENTED = "Method Not Allowed.";
  
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
        throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
    }
  }

  public Response get() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response head() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response post() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response put() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response delete() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response connect() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response options() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response trace() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }

  public Response patch() {
    throw new GenericException("Error [ Method not Allowed ]: ".concat(METHOD_NOT_IMPLEMENTED), SeverityEnum.SEV_001, 405);
  }
}
