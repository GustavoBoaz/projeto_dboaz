package com.dboaz.server.models;

import java.util.HashMap;
import java.util.Map;

import com.dboaz.server.enums.StatusCodeEnum;

public class ResponseRoute {
    private StatusCodeEnum status;
    private String contentType;
    private Map<String, String> headers;
    private String body;
    
    public ResponseRoute(Builder builder) {
        this.status = builder.status;
        this.contentType = builder.contentType;
        this.headers = builder.headers;
        this.body = builder.body;
    }

    public static class Builder {
        private StatusCodeEnum status;
        private String contentType;
        private Map<String, String> headers = new HashMap<String, String>();
        private String body;

        public ResponseRoute build() {
            return new ResponseRoute(this);
        }

        public Builder status(StatusCodeEnum status) {
            this.status = status;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }
        
        public Builder body(String body) {
            this.body = body;
            return this;
        }
    }

    public StatusCodeEnum getStatus() {
        return status;
    }

    public String getContentType() {
        return contentType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
