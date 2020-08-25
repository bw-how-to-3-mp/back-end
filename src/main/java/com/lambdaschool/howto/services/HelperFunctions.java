package com.lambdaschool.howto.services;

import com.lambdaschool.howto.models.ValidationError;

import java.util.List;

public interface HelperFunctions
{
    List<ValidationError> getConstraintViolation(Throwable cause);
}
