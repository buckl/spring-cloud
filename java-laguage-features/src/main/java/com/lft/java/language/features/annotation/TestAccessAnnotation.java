package com.lft.java.language.features.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class TestAccessAnnotation {
    public static void main(String[] args) {
        test1();
    }

    public static void test2() {
        Annotation[] annotations = Test.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
        DescriptionAnnotation description = Test.class.getAnnotation(DescriptionAnnotation.class);
        VersionAnnotation version = description.version();
        String comments = description.comments();
        Class<? extends Annotation> aClass = description.annotationType();
        Class<? extends DescriptionAnnotation> aClass1 = description.getClass();
        System.out.println(description);
    }

    public static void test1() {
        Class<AccessAnnotation> accessAnnotationClass = AccessAnnotation.class;
        printAnnotations(accessAnnotationClass);
        Method[] declaredMethods = accessAnnotationClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("Annotations for method: " + method.getName());
            printAnnotations(method);
        }
        System.out.println(accessAnnotationClass.getName());

    }

    public static void printAnnotations(AnnotatedElement annotatedElement) {
        Annotation[] annotations = annotatedElement.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            if (annotation instanceof Version) {
                Version version = (Version) annotation;
                int major = version.major();
                int minor = version.minor();
                System.out.printf("注解 version的major is %s minor is %s", major, minor);
            }
        }
    }

}
