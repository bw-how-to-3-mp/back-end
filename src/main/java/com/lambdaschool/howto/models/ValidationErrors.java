package com.lambdaschool.howto.models;

public class ValidationErrors
{
    private String Code;
    private String message;

    public String getCode()
    {
        return Code;
    }

    public void setCode(String code)
    {
        Code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ValidationErrors{" +
            "Code='" + Code + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
