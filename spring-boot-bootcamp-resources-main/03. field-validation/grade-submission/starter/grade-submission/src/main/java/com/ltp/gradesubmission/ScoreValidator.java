package com.ltp.gradesubmission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, String> {
    
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value.matches("^(100|[1-9]?[0-9])$");
        }
}
