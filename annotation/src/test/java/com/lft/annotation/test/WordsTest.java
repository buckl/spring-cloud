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
        userService.insertWords("autodidact", "自学者，自学成功的人");
        userService.insertWords("numerous", "很多的，许多的；数量庞大的；数不清的");
        userService.insertWords("tutorials", "导师的个别指导( tutorial的名词复数 )；教程；辅导材料；使用说明书");
        userService.insertWords("emphasis", "强调，重要性；重读");
        userService.insertWords("encounter", "遭遇；偶遇 n. 遭遇，偶遇；（体育）比赛");
        userService.insertWords("certification examination", "认证考试");
        userService.insertWords("adequately", "足够地；合格地");
        userService.insertWords("formulated", "构想出( formulate的过去式和过去分词 )；规划；确切地阐述；用公式表示");
        userService.insertWords("compromised", "妥协，让步的，缺乏抵抗力的，缺乏免疫力的，妥协的");
        userService.insertWords("comprehensive", "全面的；综合性的 n. （英国的公立性）综合中学");
        userService.insertWords("illustrations", "插图( illustration的名词复数 )；图表；例证；说明");
        userService.insertWords("Specification", "规格；详述；说明书");
        userService.insertWords("expected", "预料；要求；认为（某事）会发生adj. （用作定语）预期要发生的，期待中");
        userService.insertWords("signature", "签名；鲜明特色");
        userService.insertWords("exactly", "精确地，确切地；正是如此；完全正确；（要求得到更多信息）究竟，到底");
        userService.insertWords("modifier", "调节器；修饰语");
        userService.insertWords("boilerplate", "样板文件；公式化，陈词滥调");
        userService.insertWords("Primitive", "原始的；发展水平低的；落后的");
        userService.insertWords("states", "表示");
    }
}
