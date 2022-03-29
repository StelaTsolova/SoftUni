package com.example.exercisespringdataintrotwo.models.constraints.validators;

import com.example.exercisespringdataintrotwo.models.constraints.annotions.Password;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minLength;
    private int maxLength;
    private boolean containsDigit;
    private boolean containsLowercase;
    private boolean containsUppercase;
    private boolean containsSpecialSymbol;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
        this.containsDigit = constraintAnnotation.containsDigit();
        this.containsLowercase = constraintAnnotation.containsLowercase();
        this.containsUppercase = constraintAnnotation.containsUppercase();
        this.containsSpecialSymbol = constraintAnnotation.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(@NotNull String value, ConstraintValidatorContext context) {

        if (value.length() < this.minLength || value.length() > this.maxLength) {
            return false;
        }

        if (this.containsLowercase && !valueContainsLowercase(value)) {
            return false;
        }

        if (this.containsUppercase && !valueContainsUppercase(value)) {
            return false;
        }

        if (this.containsDigit && !valueContainsDigit(value)) {
            return false;
        }

        if (this.containsSpecialSymbol && !valueSpecialSymbol(value)){
            return false;
        }

        return true;
    }

    private boolean valueContainsLowercase(String value) {
        for (char symbol : value.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                return true;
            }
        }

        return false;
    }

    private boolean valueContainsUppercase(String value) {
        for (char symbol : value.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                return true;
            }
        }

        return false;
    }

    private boolean valueContainsDigit(String value) {
        for (char symbol : value.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }

        return false;
    }

    private boolean valueSpecialSymbol(String value) {
        for (char symbol : value.toCharArray()) {
            if (getSpecialSymbol().contains(String.valueOf(symbol))) {
                return true;
            }
        }

        return false;
    }

    private String getSpecialSymbol() {
        return "!@#$%^&*()_+<>?";
    }
}
