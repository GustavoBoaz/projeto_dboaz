package com.dboaz.utils.server.caller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.dboaz.utils.server.enums.StatusCodeEnum;
import com.dboaz.utils.server.models.Request;
import com.dboaz.utils.server.models.Response;
import com.google.gson.Gson;

public class Caller {
    private Request request;
    private Response response;
    private String url;
    private Map<String, String> headers;
    public Map<Comparable<Object>, Object> body;

    public Caller(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public Caller url(String url) {
        this.url = url;
        return this;
    }

    public Caller headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public Caller body(Map<Comparable<Object>, Object> body) {
        this.body = body;
        return this;
    }

    public Response send() {
        try {
            // Construir a URL com parâmetros de consulta, se houver
            StringBuilder urlStringBuilder = new StringBuilder(this.url);
            if (request.params != null && !request.params.isEmpty()) {
                urlStringBuilder.append("?");
                for (Map.Entry<String, String> entry : request.params.entrySet()) {
                    urlStringBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    urlStringBuilder.append("=");
                    urlStringBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    urlStringBuilder.append("&");
                }
                urlStringBuilder.deleteCharAt(urlStringBuilder.length() - 1); // Remover o último "&"
            }
            URL requestUrl = new URL(urlStringBuilder.toString());

            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

            // Definir o método HTTP
            connection.setRequestMethod(request.method);

            if (this.headers != null) {
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            if(!"GET".equals(request.method) && !"PATCH".equals(request.method) && this.body != null){
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    Gson gson = new Gson();
                    os.write(gson.toJson(this.body).getBytes(StandardCharsets.UTF_8));
                }
            }

            return response.builder()
                .status(StatusCodeEnum.getByCode(connection.getResponseCode()))
                .build();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException accordingly
            return null;
        }
    }
}
