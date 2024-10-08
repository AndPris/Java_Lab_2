import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringBuilderHandler {
    public void split(List<StringBuilder> parts, StringBuilder stringBuilder, String symbol) {
        int symbolIndex = stringBuilder.indexOf(symbol);
        if(symbolIndex == -1) {
            parts.add(stringBuilder);
            return;
        }

        if(symbolIndex != 0)
            parts.add(new StringBuilder(stringBuilder.substring(0, symbolIndex)));

        split(parts, new StringBuilder(stringBuilder.substring(symbolIndex+symbol.length())), symbol);
    }

    public int getAmountOfWords(StringBuilder sentence) {
        List<StringBuilder> words = new ArrayList<>();
        split(words, sentence, " ");
        return words.size();
    }

    public List<StringBuilder> sortSentencesInWordsCountOrder(StringBuilder sb) {
        List<StringBuilder> sentences = new ArrayList<>();
        split(sentences, sb, ". ");
        sentences.sort(Comparator.comparing(this::getAmountOfWords));
        return sentences;
    }

    public void displaySentencesInWordsCountOrder(StringBuilder sb) {
        sortSentencesInWordsCountOrder(sb).forEach(System.out::println);
    }
}
