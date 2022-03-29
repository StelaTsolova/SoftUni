package com.example.exercisespringdataintrotwo.models.constraints.validators;

import com.example.exercisespringdataintrotwo.models.constraints.annotions.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {

    private String regex;

    @Override
    public void initialize(Email constraintAnnotation) {
        this.regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        return matcher.find();
    }
}
