package org.CS5800.TextEditing;

import java.util.HashMap;
import java.util.Map;

// Factory to manage flyweight objects
public class CharacterPropertyFactory {
    private static final Map<String, CharacterProperty> propertiesMap = new HashMap<>();

    public static CharacterProperty getProperty(String font, String color, int size) {
        String key = font + color + size;
        CharacterProperty property = propertiesMap.get(key);
        if (property == null) {
            property = new CharacterProperty(font, color, size);
            propertiesMap.put(key, property);
        }
        return property;
    }
}
