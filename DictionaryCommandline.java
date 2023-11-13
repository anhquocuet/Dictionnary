import java.io.IOException;

public class DictionaryCommandline extends DictionaryManagement{
    //Func
    public void showAllWords(){
        DisplayAllWord();
    }
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandLine = new DictionaryCommandline();
        dictionaryCommandLine.dictionaryBasic();
    }
}
