package com.lft.annotation.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserDao userDao;

    private final WordsDao wordsDao;

    public UserService(UserDao userDao, WordsDao wordsDao) {
        this.userDao = userDao;
        this.wordsDao = wordsDao;
    }

    public void insertUser() {
        userDao.insert();
        test();
        System.out.println("用户添加完成");
    }

    @Transactional
    public void test() {
        userDao.insert();
        int i = 10 / 0;
        System.out.println("today is a good day that we are ");
    }

    @Transactional
    public void insertWords(String word, String translate) {
        wordsDao.insert(word, translate);
    }


}
