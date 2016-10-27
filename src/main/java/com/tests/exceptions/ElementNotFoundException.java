package com.tests.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String context, Integer durationInSeconds) {
        super(String.format("Element was not found %s after waiting for %d seconds", context, durationInSeconds));
    }

    public ElementNotFoundException(String context) {
        super(String.format("Element was not found %s", context));
    }
}
