package com.lft.spring;

import com.lft.spring.config.ShopConfiguration;
import com.lft.spring.entity.Product;
import com.lft.spring.entity.impl.SequenceGenerator;
import com.lft.spring.config.SequenceGeneratorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestApplication {

     public static void main(String[] args) {
         ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class, ShopConfiguration.class);
         SequenceGenerator sequenceGenerator = context.getBean(SequenceGenerator.class);
         System.out.println(sequenceGenerator.getSequence());
         System.out.println(sequenceGenerator.getSequence());
         Product aaa = context.getBean("aaa", Product.class);
         Product cdrw = context.getBean("cdrw", Product.class);
         Product dvdrw = context.getBean("dvdrw", Product.class);
         System.out.println(aaa);
         System.out.println(cdrw);
         System.out.println(dvdrw);
     }
}
