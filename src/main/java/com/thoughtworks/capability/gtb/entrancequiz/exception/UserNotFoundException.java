package com.thoughtworks.capability.gtb.entrancequiz.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}