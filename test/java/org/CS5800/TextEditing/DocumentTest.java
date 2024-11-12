package org.CS5800.TextEditing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    private Document doc;
    private final String filename = "testFile.txt";
    private final CharacterProperty testProperty = new CharacterProperty("Arial", "Red", 12);

    @BeforeEach
    void setUp() {
        doc = new Document();
    }

    @AfterEach
    void tearDown() {
        // Clean up by deleting the test file after each test
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void appendCharacter() {
        doc.appendCharacter('a', testProperty);
        assertEquals("a", doc.getText(), "Document should contain the appended character.");
    }

    @Test
    void saveToFile() throws IOException {
        doc.appendCharacter('a', testProperty);
        doc.saveToFile(filename);

        // Verify the file content
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
            }
        }

        assertEquals("a", fileContent.toString(), "File should contain the character saved from document.");
    }

    @Test
    void loadFromFile() throws IOException {
        // Set up the initial file content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("testContent");
        }

        doc.loadFromFile(filename);
        assertEquals("testContent", doc.getText(), "Document should match the content loaded from file.");
    }

    @Test
    void getText() {
        doc.appendCharacter('t', testProperty);
        doc.appendCharacter('e', testProperty);
        doc.appendCharacter('s', testProperty);
        doc.appendCharacter('t', testProperty);

        assertEquals("test", doc.getText(), "Document should return the correct text content.");
    }
}
