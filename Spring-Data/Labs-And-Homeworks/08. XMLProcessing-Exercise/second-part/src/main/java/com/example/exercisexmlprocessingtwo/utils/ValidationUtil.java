package com.example.exercisexmlprocessingtwo.utils;

import org.springframework.stereotype.Component;

import javax.xml.validation.Validator;

public interface ValidationUtil {

   <T> boolean isValid(T entity);
}
