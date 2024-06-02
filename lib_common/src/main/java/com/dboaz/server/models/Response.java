package com.dboaz.server.models;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.server.enums.StatusCodeEnum;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

public class Response {
  private static final Logger LOGGER = LogManager.getLogger(Response.class);

  private final OutputStream out;

  public Response(OutputStream out) {
    this.out = out;
  }

  public Builder builder() {
    return new Builder(this.out);
  }

  public void send() {
    try {
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      //LOGGER.error(new GenericException("Error in close response", SeverityEnum.SEV_001, 500));
    }
  }

  public static class Builder {
    private final OutputStream out;

    public Builder(OutputStream out) {
      this.out = out;
    }

    public Builder status(StatusCodeEnum status) {
      try {
        this.out.write(("HTTP/1.1 " + status.getCode() + " " + status.getDescription() + "\n").getBytes());
      } catch (IOException e) {
        LOGGER.error(new GenericException("Error in status", SeverityEnum.SEV_001, 500));
      }
      return this;
    }

    public Builder header(String key, String value) {
      try {
        this.out.write((key + ": " + value + "\n").getBytes());
      } catch (IOException e) {
        LOGGER.error(new GenericException("Error in header", SeverityEnum.SEV_001, 500));
      }
      return this;
    }

    public Builder contentType(String contentType) {
      try {
        this.out.write(("Content-Type: " + contentType + "\n").getBytes());
      } catch (IOException e) {
        //LOGGER.error(new GenericException("Error in content type", SeverityEnum.SEV_001, 500));
      }
      return this;
    }

    public Builder body(String body) {
      try {
        this.out.write("\n".getBytes());
        this.out.write(body.getBytes());
      } catch (IOException e) {
        LOGGER.error(new GenericException("Error in body", SeverityEnum.SEV_001, 500));
      }
      return this;
    }

    public Response build() {
      return new Response(this.out);
    }
  }

}
