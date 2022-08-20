package com.lft.java.language.features.annotation;

import java.io.IOException;

public class PolicyTestCases {
    // Must throw IOException
    @TestCaseAnnotation(willThrow = IOException.class)
    public static void testCase1() {
        // Code goes here
    }

    // We are not expecting any exception
    @TestCaseAnnotation()
    public static void testCase2() {
        // Code goes here
    }
}