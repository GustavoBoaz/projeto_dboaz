package com.dboaz.utils.notations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParamQuery {
    boolean required() default true;
    String name() default "";
    String nameApiDoc() default "";
}
