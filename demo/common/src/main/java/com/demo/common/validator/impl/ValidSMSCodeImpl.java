package com.demo.common.validator.impl;

import com.demo.common.util.CommonUtil;
import com.demo.common.validator.ValidSMSCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidSMSCodeImpl implements ConstraintValidator<ValidSMSCode, String> {

    @Override
    public void initialize(ValidSMSCode constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return CommonUtil.validSMSCode(s);
    }
}