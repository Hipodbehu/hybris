package org.training.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotLoremIpsumValidator implements ConstraintValidator<NotLoremIpsum, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return value != null && !value.isEmpty() && !value.toLowerCase().startsWith("lorem ipsum");
  }
}
