package com.lft.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class WordsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void  insert(String word,String translate){
        String sql = "INSERT INTO `english_words` (word,translate) VALUES(?,?)";
        jdbcTemplate.update(sql, word, translate);
    }
}
