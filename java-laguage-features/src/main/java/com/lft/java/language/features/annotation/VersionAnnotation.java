package com.lft.java.language.features.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VersionAnnotation {
    int major();

    int minor() default 1;

}
