package com.lft.annotation.test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInterpolation {
    public static String interpolationStringValues(String stringValue, Map<String, Object> data) throws Exception {
        //遍历所有的键值对
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            //构建正则表达式
            String regex1 = "\\{\\{(\\s*)" + entry.getKey() + "(\\s*)\\}\\}";
            Pattern pattern = Pattern.compile(regex1);
            //用正则表达式匹配待填充的文本
            Matcher matcher = pattern.matcher(stringValue);
            //将匹配到的文本全部替换为键值对中的值
            stringValue = matcher.replaceAll(entry.getValue().toString());
        }
        //检查是否剩余有未被替换的字符串
        String regex2 = "\\{\\{(\\s*)(\\S+)(\\s*)\\}\\}";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(stringValue);
        if (matcher.find()) {
            throw new Exception("键值对不足");
        }
        return stringValue;
    }

    public static void main(String[] args) throws Exception {
        String string = "my name is {{ name}} and i am {{age }}";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lft");
        map.put("age", 18);
        System.out.println(interpolationStringValues(string, map));

    }


}
