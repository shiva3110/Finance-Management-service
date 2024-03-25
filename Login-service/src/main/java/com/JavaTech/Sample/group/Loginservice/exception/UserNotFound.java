package com.JavaTech.Sample.group.Loginservice.exception;

public class UserNotFound extends RuntimeException{

    public UserNotFound() {
    }

    public UserNotFound(String message) {
        super(message);
    }
}
