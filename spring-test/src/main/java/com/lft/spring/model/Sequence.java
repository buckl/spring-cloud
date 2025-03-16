package com.lft.spring.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;
}