package com.dboaz.server.models;

import java.util.ArrayList;
import java.util.List;

public class RouteDetail {
    private String name;
    private String method;
    private String childPath;
    private String fullPath;
    private List<ParamDetail> parametes;

    public RouteDetail(String name, String method, String childPath, String fullPath) {
        this.name = name;
        this.method = method;
        this.childPath = childPath;
        this.fullPath = fullPath;
        this.parametes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getChildPath() {
        return childPath;
    }

    public void setChildPath(String childPath) {
        this.childPath = childPath;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public List<ParamDetail> getParametes() {
        return parametes;
    }

    public void addParameter(ParamDetail parameter) {
        this.parametes.add(parameter);
    }
}
