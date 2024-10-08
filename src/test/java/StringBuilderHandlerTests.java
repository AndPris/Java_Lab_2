import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringBuilderHandlerTests {
    private StringBuilderHandler stringBuilderHandler;
    private StringBuilder sentence;
    private StringBuilder sentences;

    @BeforeEach
    public void setUp() {
        stringBuilderHandler = new StringBuilderHandler();
        sentence = new StringBuilder("This is a test sentence.");
        sentences = new StringBuilder("Test sentence. This is the second one. Last");
    }

    @Test
    void getAmountOfWordsTest() {
        assertEquals(5, stringBuilderHandler.getAmountOfWords(sentence));
    }

    @Test
    void splitTest1() {
        List<StringBuilder> actualParts = new ArrayList<>();
        stringBuilderHandler.split(actualParts, sentence, " ");

        List<StringBuilder> expectedParts = new ArrayList<>();
        expectedParts.add(new StringBuilder("This"));
        expectedParts.add(new StringBuilder("is"));
        expectedParts.add(new StringBuilder("a"));
        expectedParts.add(new StringBuilder("test"));
        expectedParts.add(new StringBuilder("sentence."));

        for(int i = 0; i < expectedParts.size(); i++)
            assertEquals(expectedParts.get(i).toString(), actualParts.get(i).toString());
    }

    @Test
    void splitTest2() {
        List<StringBuilder> actualParts = new ArrayList<>();
        stringBuilderHandler.split(actualParts, sentences, ". ");

        List<StringBuilder> expectedParts = new ArrayList<>();
        expectedParts.add(new StringBuilder("Test sentence"));
        expectedParts.add(new StringBuilder("This is the second one"));
        expectedParts.add(new StringBuilder("Last"));

        for(int i = 0; i < expectedParts.size(); i++)
            assertEquals(expectedParts.get(i).toString(), actualParts.get(i).toString());
    }

    @Test
    void sortSentencesInWordsCountOrderTest() {
        List<StringBuilder> actualSentences = stringBuilderHandler.sortSentencesInWordsCountOrder(sentences);

        List<StringBuilder> expectedSentences = new ArrayList<>();
        expectedSentences.add(new StringBuilder("Last"));
        expectedSentences.add(new StringBuilder("Test sentence"));
        expectedSentences.add(new StringBuilder("This is the second one"));

        for(int i = 0; i < expectedSentences.size(); i++)
            assertEquals(expectedSentences.get(i).toString(), actualSentences.get(i).toString());
    }
}
