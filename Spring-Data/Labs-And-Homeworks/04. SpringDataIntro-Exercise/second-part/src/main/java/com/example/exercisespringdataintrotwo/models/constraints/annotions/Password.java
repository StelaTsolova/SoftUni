package com.example.exercisespringdataintrotwo.models.constraints.annotions;

import com.example.exercisespringdataintrotwo.models.constraints.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default ("{javax.validation.constraints.Password.message}");

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minLength();

    int maxLength();

    boolean containsLowercase() default false;

    boolean containsUppercase() default false;

    boolean containsDigit() default false;

    boolean containsSpecialSymbol() default false;

}
