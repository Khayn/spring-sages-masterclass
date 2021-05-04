package spring.masterclass.sages.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {

    private int minLength;

    @Override
    public void initialize(Name constraint) {
        minLength = constraint.minLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() >= minLength;
    }

}
