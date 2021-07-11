package com.spotts.json_parser;

import com.spotts.json_parser.context.JsonParserContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JsonParserContext.class)
public class JsonParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonParserApplication.class, args);
	}
}
