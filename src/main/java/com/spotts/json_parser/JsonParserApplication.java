package com.spotts.json_parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class JsonParserApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JsonParserApplication.class, args);
		String json = "{" +
				"  \"timestamp\": 1609516058," +
				"  \"category\": \"A\"," +
				"  \"value\": 12.345" +
				"}";
//		RecordService.parseJson(json);
		RecordService.parseJson();
	}
}
