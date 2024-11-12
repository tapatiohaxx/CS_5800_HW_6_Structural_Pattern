package org.CS5800.TextEditing;

import java.io.*;

// Class representing the text document
public class Document {
    private StringBuilder content = new StringBuilder();
    private CharacterProperty property;

    public void appendCharacter(char c, CharacterProperty property) {
        this.property = property;  // Normally, we would store properties for each character
        content.append(c);
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content.toString());
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
    }

    public String getText() {
        return content.toString();
    }
}

