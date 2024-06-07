package com.dboaz.server.models;

public class ParamDetail {
    private boolean required;
    private Class<?> type;
    private String nameType;
    private String name;

    public ParamDetail(Class<?> type, String nameType, String name, boolean required) {
        this.type = type;
        this.nameType = nameType;
        this.name = name;
        this.required = required;
    }

    public ParamDetail(Class<?> type, String nameType, boolean required) {
        this.type = type;
        this.nameType = nameType;
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public Class<?> getType() {
        return type;
    }

    public String getNameType() {
        return nameType;
    }

    public String getName() {
        return name;
    }
}
