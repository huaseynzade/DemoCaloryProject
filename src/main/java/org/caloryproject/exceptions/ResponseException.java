package org.caloryproject.exceptions;

import lombok.Data;

@Data
public class ResponseException {
    private String message;

    public ResponseException(String message) {
        this.message = message;
    }
}
