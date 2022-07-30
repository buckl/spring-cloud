package com.lft.annotation.test;

import com.lft.annotation.tx.TxConfig;
import com.lft.annotation.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WordsTest {
    @Test
    public void testUserInsert() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertWords("detected", "操场，尤指提供如秋千等设备的户外场地；游乐场；（某些集体聚会游乐的）园地") ;



    }
}
