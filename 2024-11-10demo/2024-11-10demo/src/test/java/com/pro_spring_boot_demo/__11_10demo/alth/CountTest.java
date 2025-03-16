package com.pro_spring_boot_demo.__11_10demo.alth;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountTest extends TestCase {
    @Test
    public void test() {
        Count count = new Count();
        int i = count.countKConstraintSubstrings("10101", 1);
        System.out.println(i);
        int i2 = count.countKConstraintSubstrings("1010101", 2);
        System.out.println(i2);
        int i3 = count.countKConstraintSubstrings("11111", 1);
        System.out.println(i3);
    }

    public void test1() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = new String(br.readLine());
        String input2 = new String(br.readLine());
        //先记录一个标准顺序表
        String word = new String("abcdefghijklmnopqrstuvwxyz");
        //再来一个待修改的顺序表
        String word2 = word;
        StringBuffer newword = new StringBuffer();
        for(int i = 0 ; i<input1.length();i++){
            if(word2.contains(String.valueOf(input1.charAt(i)) )){
                //如果有,就删除,再给新表加上
                word2 = word2.replace(String.valueOf(input1.charAt(i)),"");
                newword.append(String.valueOf(input1.charAt(i)));
            }
        }
        //把删除之后剩余部分拿了过来接上
        newword.append(word2);
        //遍历输入的第二行,与标准字母排序,找到对应的单词,记录下标准的单词序号
        //从新单词表中按照这个序号,找到对应的字母,添加到新的字符串中
        StringBuffer newword2 = new StringBuffer();
        for(int i = 0 ;i <input2.length();i++){
            for(int j = 0 ;j<newword.length();j++){
                if(input2.charAt(i)==word.charAt(j)){
                    newword2.append(String.valueOf(newword.charAt(j)));
                }
            }
        }
        System.out.println(newword2);


    }

    public void test3(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 1 || n == 2) {
                System.out.println(-1);
            } else if (n % 4 == 3 || n % 4 == 1) {
                System.out.println(2);
            } else if (n % 4 == 0) {
                System.out.println(3);
            } else if (n % 4 == 2) {
                System.out.println(4);
            }
        }
    }

    @Test
    public void test2(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 1 || n == 2) {
                System.out.println(-1);
            } else if (n % 4 == 3 || n % 4 == 1) {
                System.out.println(2);
            } else if (n % 4 == 0) {
                System.out.println(3);
            } else if (n % 4 == 2) {
                System.out.println(4);
            }
        }
    }
}