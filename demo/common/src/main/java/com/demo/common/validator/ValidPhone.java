package com.demo.common.validator;

import com.demo.common.validator.impl.ValidPhoneImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 手机号校验器
 *
 * @author kxw
 * @version 2017/2/10 15:18
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPhoneImpl.class)
public @interface ValidPhone {

    String message() default "请输入正确的手机号码";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
