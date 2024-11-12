package org.CS5800.TextEditing;
import java.io.IOException;

public class TextEditor {
    private Document document;

    public TextEditor(Document document) {
        this.document = document;
    }

    public void runEditor() throws IOException {
        CharacterProperty arialRed12 = CharacterPropertyFactory.getProperty("Arial", "Red", 12);
        CharacterProperty calibriBlue14 = CharacterPropertyFactory.getProperty("Calibri", "Blue", 14);
        CharacterProperty verdanaBlack16 = CharacterPropertyFactory.getProperty("Verdana", "Black", 16);

        appendTextWithProperties(arialRed12, calibriBlue14, verdanaBlack16);

        document.saveToFile("HelloWorldCS5800.txt");
        document.loadFromFile("HelloWorldCS5800.txt");
        System.out.println(document.getText());
    }

    private void appendTextWithProperties(CharacterProperty... properties) {
        char[] text = new char[]{'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd', 'C', 'S', '5', '8', '0', '0'};
        for (int i = 0; i < text.length; i++) {
            document.appendCharacter(text[i], properties[i % properties.length]);
        }
    }

    public static void main(String[] args) {
        try {
            new TextEditor(new Document()).runEditor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
