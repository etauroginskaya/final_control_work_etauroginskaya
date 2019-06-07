package com.gmail.etauroginskaya.finalcontrolwork.service.validator;

import com.gmail.etauroginskaya.finalcontrolwork.service.validator.annotations.NotEarlierYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class NotEarlierYearConstraintValidator implements ConstraintValidator<NotEarlierYear, String> {

    @Override
    public void initialize(NotEarlierYear constraint) {
    }

    @Override
    public boolean isValid(String data, ConstraintValidatorContext cxt) {
        try {
            if (LocalDateTime.parse(data).isAfter(LocalDateTime.now().plusYears(1L)))
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}