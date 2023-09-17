package com.walker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConvertorController {

    private final CSVConverterService converterService;

    @Autowired
    public ConvertorController(CSVConverterService converterService) {
        this.converterService = converterService;
    }


    @GetMapping("/convert")
    public String convertCSVToFormat(@RequestParam(name = "format", defaultValue = "table") String format) {
        // Assume 'data' is your CSV data retrieved from somewhere (e.g., read from a file)
        // You can pass 'data' to the appropriate conversion method based on the 'format' parameter
        // and return the converted result

        List<Map<String, String>> data = getDataFromSomeSource();

        if ("json".equalsIgnoreCase(format)) {
            return converterService.convertToJSON(data);
        } else if ("xml".equalsIgnoreCase(format)) {
            return converterService.convertToXML(data);
        } else {
            return converterService.convertToTable(data);
        }
    }

    // Replace this method with your actual data retrieval logic
    private List<Map<String, String>> getDataFromSomeSource() {
        // Implement data retrieval logic here (e.g., reading from a CSV file)
        // Return a list of maps representing CSV data
        return null;
    }


}
