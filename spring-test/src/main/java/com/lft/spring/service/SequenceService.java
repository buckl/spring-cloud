package com.lft.spring.service;

import com.lft.spring.dao.SequenceDao;
import com.lft.spring.model.Sequence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SequenceService {
    private final SequenceDao sequenceDao;

    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}