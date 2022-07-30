package com.lft.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class LftSelect implements ImportSelector {
    /**
     * @param importingClassMetadata 获取被Import标记的类上的其他注解信息
     * @return 导入到容器中的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAnnotationTypes();
        return new String[0];
    }
}
