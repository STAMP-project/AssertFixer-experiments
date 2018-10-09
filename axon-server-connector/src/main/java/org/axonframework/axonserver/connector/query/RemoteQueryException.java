package org.axonframework.axonserver.connector.query;

import io.axoniq.axonserver.grpc.ErrorMessage;

/**
 * Author: marc
 */
public class RemoteQueryException extends RuntimeException {
    private final String errorCode;
    private final String location;
    private final Iterable<String> details;

    public RemoteQueryException(String errorCode, ErrorMessage message) {
        super(message.getMessage());

        details = message.getDetailsList();
        this.errorCode = errorCode;
        location = message.getLocation();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getLocation() {
        return location;
    }

    public Iterable<String> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "RemoteQueryException{" +
                "message=" + getMessage() +
                ", errorCode='" + errorCode + '\'' +
                ", location='" + location + '\'' +
                ", details=" + details +
                '}';
    }

}
