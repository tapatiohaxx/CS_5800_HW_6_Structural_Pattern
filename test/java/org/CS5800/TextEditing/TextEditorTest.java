package org.CS5800.TextEditing;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class TextEditorTest {

    private Document mockDocument;
    private TextEditor textEditor;

    @BeforeEach
    void setUp() {
        mockDocument = mock(Document.class);
        textEditor = new TextEditor(mockDocument);
    }

    @Test
    void testRunEditor() throws IOException {
        doNothing().when(mockDocument).saveToFile(anyString());
        doNothing().when(mockDocument).loadFromFile(anyString());
        when(mockDocument.getText()).thenReturn("HelloWorldCS5800");

        textEditor.runEditor();

        verify(mockDocument, times(16)).appendCharacter(anyChar(), any(CharacterProperty.class));
        verify(mockDocument, times(1)).saveToFile("HelloWorldCS5800.txt");
        verify(mockDocument, times(1)).loadFromFile("HelloWorldCS5800.txt");
        assertEquals("HelloWorldCS5800", mockDocument.getText());
    }
}
