package com.dboaz.utils.notations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBoazBootApp {
    String name() default "";
    String date() default "";
    String version() default "01.00.000-version";
    String release() default "01.00.000-release";
}
