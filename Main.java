public class Main {
  public static void main(String[] args) {
    Dictionary dictionary = new Dictionary();
    DictionaryManagement dM = new DictionaryManagement(dictionary);
    DictionaryCommandline dCommandLine = new DictionaryCommandline(dM);

    dCommandLine.dictionaryBasic();
  }
}