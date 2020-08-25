package com.lambdaschool.howto.exceptions;

public class ResourceFoundException extends RuntimeException
{
    public ResourceFoundException(String message) {
        super("Error from Lambda School App " + message);
    }
}