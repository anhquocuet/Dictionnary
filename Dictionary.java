import java.util.ArrayList;

public class Dictionary {

  public ArrayList<Word> words;

  /**
   * khoitao.
   */
  public Dictionary() {
    words = new ArrayList<Word>();
  }

  /**
   * addword.
   */
  public void addNewords(Word word) {
    words.add(word);
  }

  /**
   * getter.
   */
  public ArrayList<Word> getWords() {
    return words;
  }
}