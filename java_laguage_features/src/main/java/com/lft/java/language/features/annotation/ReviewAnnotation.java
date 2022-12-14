package com.lft.java.language.features.annotation;

public @interface ReviewAnnotation {
    ReviewStatus status() default ReviewStatus.PENDING;

    String comments() default "";

    // ReviewStatus enum is a member of the Review annotation type
    public enum ReviewStatus {PENDING, FAILED, PASSED, PASSED_WITH_CHANGES}
}