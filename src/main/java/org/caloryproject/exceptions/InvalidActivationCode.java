package org.caloryproject.exceptions;

public class InvalidActivationCode extends RuntimeException{
    public InvalidActivationCode(String message) {
        super(message);
    }
}
