package com.lft.java.language.features.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * The annotation processor object is instantiated by the compiler using a no-args constructor
 * SupportedAnnotationTypes 定义该处理器需要处理的注解类型，*可以作为通配符匹配包下面所有的注解
 * SupportedSourceVersion jdk版本
 * Processor采用循环查找处理，返回false让下一个Processor处理
 */
@SupportedAnnotationTypes({"com.lft.java.language.features.annotation.Version"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class VersionProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Process all annotations
        for (TypeElement currentAnnotation : annotations) {
            Name qualifiedName = currentAnnotation.getQualifiedName();
            // check if it is a Version annotation
            if (qualifiedName.contentEquals("com.lft.java.language.features.annotation.Version")) {
                // Look at all elements that have Version annotations
                Set<? extends Element> annotatedElements;
                annotatedElements = roundEnv.getElementsAnnotatedWith(currentAnnotation);
                for (Element element : annotatedElements) {
                    Version v = element.getAnnotation(Version.class);
                    int major = v.major();
                    int minor = v.minor();
                    if (major < 0 || minor < 0) {
                        String errorMsg = "Version cannot be negative." +
                                " major=" + major +
                                " minor=" + minor;
                        Messager messager = this.processingEnv.getMessager();
                        messager.printMessage(Diagnostic.Kind.ERROR, errorMsg, element);
                    }
                }
            }
        }
        return true;
    }
}
