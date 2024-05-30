package com.dboaz.utils.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.dboaz.utils.server.abstracts.AbstractServerUtil;
import com.dboaz.utils.server.models.Request;
import com.dboaz.utils.server.models.Response;

public class Server extends AbstractServerUtil {
  private static final Logger LOGGER = LogManager.getLogger(Server.class);

  private Integer port;

  public Server(Integer port) {
    this.port = port;
  }
  
  public void start() {
    try (ServerSocket server = new ServerSocket(port)) {
      LOGGER.info("Server is running on port: {}", port);
      while (true) {
        new ClientConnection(server.accept(), this).start();
      }
    } catch (IOException e) {
      LOGGER.error(new GenericException("Error [start server]: ".concat(e.getMessage()), SeverityEnum.SEV_001, 500));
    }
  }

  protected static class ClientConnection extends Thread {
    protected Socket client;
    protected Server server;

    public ClientConnection(Socket client, Server server) {
      this.client = client;
      this.server = server;
    }

    @Override
    public void run() {
      LOGGER.info("| {} | Client {} connected.", Thread.currentThread().getName(), client.getInetAddress().getHostAddress());    

      try (
        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream()
      ) {
        // process request
        Request request = new Request(input);

        // process response
        Response response = new Response(output);

        // process middlewares and controller
        Response result = server.executeMiddlewares(request, response) ? server.executeController(request, response) : response;

        result.send();

      } catch (IOException e) {
        LOGGER.error(new GenericException("Error [Input or output straem]: ".concat(e.getMessage()), SeverityEnum.SEV_001, 500));
      } finally {
        try {
          LOGGER.info("| {} | Client {} disconnected.", Thread.currentThread().getName(), client.getInetAddress().getHostAddress());
          client.close();
        } catch (IOException e) {
          LOGGER.error(new GenericException("Error [close client connection]: ".concat(e.getMessage()), SeverityEnum.SEV_001, 500));
        }
      }
    }
  }
}
