import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {
    protected static ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public static void sortWordList(ArrayList<Word> wordArrayList) {
        Collections.sort(wordArrayList, new Comparator<Word>() {
            public int compare(Word word1, Word word2) {
                return word1.getWord_target().compareTo(word2.getWord_target());
            }
        });
    }

    public static void addWord(Word word) {
        int index = Collections.binarySearch(words,
                word,
                Comparator.comparing(Word::getWord_target));
        if (index < 0) {
            index = -(index + 1);
            words.add(index, word);
            sortWordList(words);
        } else System.out.println("Vocab has already existed!!");
    }

    public void DisplayAllWord() {
        System.out.println("+------+----------------------+---------------------------+");
        System.out.println("| NO   | English              | Vietnamese                |");
        System.out.println("+------+----------------------+---------------------------+");
        for (int i = 0; i < words.size(); ++i) {
            String format = String.format("| %-4d | %-20s | %-25s |",
                    (i + 1), words.get(i).getWord_target(), words.get(i).getWord_explain());
            String line = String.format("%4s", "").replace(' ', '-');
            String line1 = String.format("%20s", "").replace(' ', '-');
            String line2 = String.format("%25s", "").replace(' ', '-');
            String formatDown = "+-" + line + "-+-" + line1 + "-+-" + line2 + "-+";
            System.out.println(format);
            System.out.println(formatDown);
        }
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }
}