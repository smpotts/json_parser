package com.spotts.json_parser.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotts.json_parser.context.JsonParserContext;
import com.spotts.json_parser.model.Record;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void setup() {
        try {
            parseJson();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        recordList = objectMapper.readValue(new File(inputDataPath),
                new TypeReference<List<Record>>(){});
    }

    public String calculateAvgValue() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Double> catValueMap =
                recordList.stream().collect(
                        Collectors.groupingBy(
                                Record::getCategory,
                                Collectors.summingDouble(Record::getValue)
                        )
                );

        stringBuilder.append("Average Values by Category:");
        for (String k : catValueMap.keySet()) {
            stringBuilder.append(k).append(": ").append(catValueMap.get(k)).append(", ");
        }
        return stringBuilder.toString();
    }
}
