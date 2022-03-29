package com.example.exercisespringdataintrotwo.models.constraints.annotions;

import com.example.exercisespringdataintrotwo.models.constraints.validators.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {

    String message() default ("{javax.validation.constraints.Email.message}");

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String regex();
}
