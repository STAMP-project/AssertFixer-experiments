package com.aliyuncs.fc.model;

public class RouteConfig {
    private PathConfig[] routes;

    public RouteConfig(PathConfig[] routes) {
        this.routes = routes;
    }

    public PathConfig[] getRoutes() {
        return routes;
    }

    public void setRoutes(PathConfig[] routes) {
        this.routes = routes;
    }
}
