package org.CS5800.TextEditing;

// Flyweight object class
public class CharacterProperty {
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperty(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
