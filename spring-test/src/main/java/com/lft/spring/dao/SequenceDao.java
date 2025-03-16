package com.lft.spring.dao;

import com.lft.spring.model.Sequence;

public interface SequenceDao {
    Sequence getSequence(String sequenceId);

    int getNextValue(String sequenceId);
}