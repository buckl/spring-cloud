package com.lft.java.language.features.annotation;

public @interface Enabled {
    boolean status() default true;
}