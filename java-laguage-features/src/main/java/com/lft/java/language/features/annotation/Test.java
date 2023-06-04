package com.lft.java.language.features.annotation;

@DescriptionAnnotation(name = ("John"),
        version = @VersionAnnotation(major = 1, minor = 2),
        comments = "Just a test class")
public class Test {
    /**
     * 注解使用在看起来很特殊的方
     *
     * @throws  Exception 致命的
     * FatalAnnotation
     */
    public void processDate() throws @FatalAnnotation Exception {
        double value = getValue();
        int roundedValue = (@NonZero int) value;
        Test t = new @FatalAnnotation Test();
    }

    public double getValue() {
        return 189.98;
    }
}