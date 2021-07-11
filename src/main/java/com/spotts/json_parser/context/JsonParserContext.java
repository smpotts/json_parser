package com.spotts.json_parser.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The Context.
 */
@Data
@ConfigurationProperties(prefix = "record")
public class JsonParserContext {
    private String inputData;
}
