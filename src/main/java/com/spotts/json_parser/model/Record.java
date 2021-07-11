package com.spotts.json_parser.model;

import lombok.Data;

import java.math.BigInteger;

/**
 * A Record object.
 */
@Data
public class Record {
    private BigInteger timestamp;
    private String category;
    private Double value;
}
