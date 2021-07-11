package com.spotts.json_parser.controller;

import com.spotts.json_parser.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Controller.
 */
@RestController
@RequestMapping("/")
public class JsonParserController {

    @Autowired
    RecordService recordService;

    @GetMapping
    public String results() {
        return recordService.calculateAvgValue();
    }
}
