import java.util.Collections;
import java.util.Comparator;

public class DictionaryCommandline {
  public DictionaryManagement dManagement;

  public DictionaryCommandline(DictionaryManagement dictionaryManagement) {
    this.dManagement = dictionaryManagement;
  }

  public void showAllWords() {
    /** sapxep word theo alphabet. */
    Collections.sort(dManagement.dictionary.words, new Comparator<Word>() {
      @Override
      public int compare(Word word1, Word word2) {
        return word1.getWord_target().compareTo(word2.getWord_explain());
      }
    });
    /** in ra. */
    System.out.printf("%-5s |  %-20s |  %-20s%n", "No", "English", "Vietnamese");
    for (int i = 0; i < dManagement.dictionary.words.size(); i++) {
      Word word = dManagement.dictionary.words.get(i);
      System.out.printf("%-5d |  %-20s |  %-20s%n", i + 1, word.getWord_target(), word.getWord_explain());
    }
  }

  public void dictionaryBasic() {
    dManagement.insertFromCommandline();
    showAllWords();
  }
}