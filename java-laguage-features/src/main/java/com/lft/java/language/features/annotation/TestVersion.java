package com.lft.java.language.features.annotation;

import java.lang.annotation.Annotation;

public class TestVersion implements VersionAnnotation {
    @Override
    public int major() {
        return 0;
    }

    @Override
    public int minor() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
