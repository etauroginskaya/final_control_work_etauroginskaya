package com.gmail.etauroginskaya.finalcontrolwork.service.validator.annotations;

import com.gmail.etauroginskaya.finalcontrolwork.service.validator.NotEarlierYearConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = NotEarlierYearConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEarlierYear {

    String message() default "Expiration Date must not be earlier than a year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}