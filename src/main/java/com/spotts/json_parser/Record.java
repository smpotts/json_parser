package com.spotts.json_parser;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Record {
    private BigInteger timestamp;
    private String category;
    private Double value;
}
