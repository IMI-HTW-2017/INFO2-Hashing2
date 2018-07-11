import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordGenerator {

    private Set<String> foundWords;

    WordGenerator(String word) {
        foundWords = new HashSet<>();

        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        word = new String(charArray);

        foundWords.add(word);
        generateWords(word.length());
    }

    private void generateWords(int wordLength) {
        if (wordLength <= 2)
            return;

        for (Object o : foundWords.stream().filter(w -> w.length() == wordLength).toArray()) {
            String word = (String) o;
            for (int i = 0; i < wordLength; i++) {
                char[] charArray = word.toCharArray();
                charArray[i] = 0;

                StringBuilder foundWord = new StringBuilder();
                for (char aCharArray : charArray) {
                    if (aCharArray != 0)
                        foundWord.append(aCharArray);
                }
                foundWords.add(foundWord.toString());
            }
        }

        generateWords(wordLength - 1);
    }

    public Set<String> getWords() {
        return foundWords;
    }

}
