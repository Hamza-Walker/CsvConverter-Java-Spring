package com.walker.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterManagerImpl implements ConverterManager{

    @Override
    public List<Map<String, String>> readCSV(String fileName) {

        List<Map<String, String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] headers = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (headers == null) {
                    headers = values;
                } else {
                    Map<String, String> row = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        if (i < values.length) {
                            row.put(headers[i], values[i]);
                        } else {
                            row.put(headers[i], "");
                        }
                    }
                    data.add(row);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
