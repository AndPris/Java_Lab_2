import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringBuilderHandler {
    private StringBuilder sb;

    public StringBuilderHandler(String sentences) {
        this.sb = new StringBuilder(sentences);
    }

    public void split(List<StringBuilder> parts, StringBuilder stringBuilder, String symbol) {
        int symbolIndex = stringBuilder.indexOf(symbol);
        if(symbolIndex == -1) {
            parts.add(stringBuilder);
            return;
        }

        if(symbolIndex != 0)
            parts.add(new StringBuilder(stringBuilder.substring(0, symbolIndex)));

        split(parts, new StringBuilder(stringBuilder.substring(symbolIndex+1)), symbol);
    }

    public int getAmountOfWords(StringBuilder sentence) {
        List<StringBuilder> words = new ArrayList<>();
        split(words, sentence, " ");
        return words.size();
    }

    public void displaySentencesInWordsCountOrder() {
        List<StringBuilder> sentences = new ArrayList<>();
        split(sentences, sb, ".");
        sentences.sort(Comparator.comparing(this::getAmountOfWords));
        sentences.forEach(System.out::println);
    }
}
