package com.lft.java.language.features.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 该注解允许在任何地方使用
 */
@Target({ElementType.TYPE_USE})
public @interface FatalAnnotation {
}