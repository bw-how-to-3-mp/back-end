package com.lambdaschool.howto.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {
        super("Error from Lambda School App " + message);
    }
}