package com.spotts.json_parser;

import com.spotts.json_parser.context.JsonParserContext;
import com.spotts.json_parser.model.Record;
import com.spotts.json_parser.service.RecordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class RecordServiceTest {
    private final JsonParserContext context = new JsonParserContext();

    @Test
    public void parseSingleJsonTest() throws IOException {
        // test when there is only one record
        context.setInputData("src/test/resources/single_record.json");
        RecordService recordService = new RecordService(context);
        recordService.parseJson();
        List<Record> results =  recordService.getRecordList();
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("A", results.get(0).getCategory());
        Assertions.assertEquals(BigInteger.valueOf(1609516058), results.get(0).getTimestamp());
    }

    @Test
    public void parseMultiJsonTest() throws IOException {
        context.setInputData("src/test/resources/multi_record.json");
        RecordService recordService = new RecordService(context);
        recordService.parseJson();
        List<Record> results =  recordService.getRecordList();
        Assertions.assertEquals(3, results.size());
        Assertions.assertEquals("C", results.get(2).getCategory());
        Assertions.assertEquals(Double.valueOf(252.732), results.get(2).getValue());
    }

    @Test
    public void calculateSumValueTest() throws IOException {
        context.setInputData("src/test/resources/multi_record.json");
        RecordService recordService = new RecordService(context);
        recordService.parseJson();
        String resultString = recordService.calculateSumValue();
        Assertions.assertEquals("Sum of Values by Category: A: 12.345 B: 1.022 C: 252.732 ", resultString);
    }
}