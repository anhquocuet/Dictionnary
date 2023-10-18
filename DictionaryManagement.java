import java.util.Scanner;

public class DictionaryManagement {
  public Dictionary dictionary;
/** khoi tao. */
  public DictionaryManagement(Dictionary dictionary) {
    this.dictionary = dictionary;
  }
/** add newwords. */
  public void insertFromCommandline() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhập số lượng từ vựng: ");
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      System.out.printf("Nhập từ vựng thứ %d:\n", i + 1);

      System.out.print("Từ tiếng Anh: ");
      String word_target_ = sc.nextLine();
      System.out.print("Giải nghĩa tiếng Việt: ");
      String word_explain_ = sc.nextLine();
      Word newwords = new Word(word_target_, word_explain_);
      dictionary.addNewords(newwords);
      System.out.print("\n");
    }
  }
/** getter. */
  public Dictionary getDictionary() {
    return dictionary;
  }
}