package com.spotts.json_parser.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotts.json_parser.context.JsonParserContext;
import com.spotts.json_parser.model.Record;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Service for the Record objects.
 */
@Component
public class RecordService {
    private static List<Record> recordList;
    private final String inputDataPath;

    public RecordService(JsonParserContext context) {
        inputDataPath = context.getInputData();
    }

    public void parseJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        recordList = objectMapper.readValue(new File(inputDataPath),
                new TypeReference<List<Record>>(){});
    }

    public String calculateSumValue() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Double> catValueMap =
                recordList.stream().collect(
                        Collectors.groupingBy(
                                Record::getCategory,
                                Collectors.summingDouble(Record::getValue)
                        )
                );

        stringBuilder.append("Sum of Values by Category: ");
        for (String k : catValueMap.keySet()) {
            stringBuilder.append(k).append(": ").append(catValueMap.get(k)).append(" ");
        }
        return stringBuilder.toString();
    }

    public List<Record> getRecordList() {
        return recordList;
    }
}
