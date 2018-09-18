package com.aliyuncs.fc.model;

public class PathConfig {
    private String path;
    private String serviceName;
    private String functionName;
    private String qualifier;

    public PathConfig(String path, String serviceName, String functionName, String qualifier) {
        this.path = path;
        this.serviceName = serviceName;
        this.functionName = functionName;
        this.qualifier = qualifier;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
}
