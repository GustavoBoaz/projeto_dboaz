package com.dboaz.server.models;

public class ParamDetail {
    private Class<?> notationType;
    private Class<?> type;
    private String nameType;
    private String name;
    private boolean required;

    public ParamDetail(Class<?> notationType, Class<?> type, String nameType, String name, boolean required) {
        this.notationType = notationType;
        this.type = type;
        this.nameType = nameType;
        this.name = name;
        this.required = required;
    }

    public ParamDetail(Class<?> notationType, Class<?> type, String nameType, boolean required) {
        this.notationType = notationType;
        this.type = type;
        this.nameType = nameType;
        this.required = required;
    }

    public Class<?> getNotationType() {
        return notationType;
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

    public boolean isRequired() {
        return required;
    }
}
