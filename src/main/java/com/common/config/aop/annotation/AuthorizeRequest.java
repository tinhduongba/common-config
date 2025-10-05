package com.common.config.aop.annotation;

import com.common.config.enumclass.ERole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthorizeRequest {
    ERole[] roles() default {};
}