package com.walker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConverterManagerImplTest {
    private ConverterManagerImpl converterManager;

    @BeforeEach
    void setUp() {
        converterManager = new ConverterManagerImpl();
    }

    @Test
    void testReadCSV(@TempDir Path tempDir) throws IOException {
        // Create a sample CSV file in a temporary directory
        File csvFile = tempDir.resolve("sample.csv").toFile();
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.println("Name,Age,Location");
            writer.println("John,30,New York");
            writer.println("Alice,25,San Francisco");
        }

        // Call the readCSV method with the temporary CSV file
        List<Map<String, String>> data = converterManager.readCSV(csvFile.getAbsolutePath());

        // Perform assertions on the data
        assertNotNull(data);
        assertEquals(2, data.size());

        Map<String, String> row1 = data.get(0);
        Map<String, String> row2 = data.get(1);
        System.out.println(data);

        assertEquals("John", row1.get("Name"));
        assertEquals("30", row1.get("Age"));
        assertEquals("New York", row1.get("Location"));

        assertEquals("Alice", row2.get("Name"));
        assertEquals("25", row2.get("Age"));
        assertEquals("San Francisco", row2.get("Location"));
    }

}