package org.CS5800.TextEditing;
import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterPropertyFactoryTest {

    @Test
    public void testCharacterPropertyReusing() {
        CharacterProperty cp1 = CharacterPropertyFactory.getProperty("Arial", "Red", 12);
        CharacterProperty cp2 = CharacterPropertyFactory.getProperty("Arial", "Red", 12);
        assertSame(cp1, cp2);  // They should be the same instance
    }

    @Test
    public void testCharacterPropertyUniqueCreation() {
        CharacterProperty cp1 = CharacterPropertyFactory.getProperty("Arial", "Red", 12);
        CharacterProperty cp2 = CharacterPropertyFactory.getProperty("Calibri", "Blue", 14);
        assertNotSame(cp1, cp2);  // They should be different instances
    }
}
