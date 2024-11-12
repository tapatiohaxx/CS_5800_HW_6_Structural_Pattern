package org.CS5800.TextEditing;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterPropertyTest {

    @Test
    public void testCreateCharacterProperty() {
        CharacterProperty cp = new CharacterProperty("Arial", "Red", 12);
        assertNotNull(cp);
        assertEquals("Arial", cp.getFont());
        assertEquals("Red", cp.getColor());
        assertEquals(12, cp.getSize());
    }
}
