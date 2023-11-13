import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng từ vựng: ");
        int word_size = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < word_size; i++) {
            System.out.printf("Nhập từ vựng thứ %d:\n", i + 1);
            System.out.print("Từ tiếng Anh: ");
            String word_target_ = sc.nextLine();
            System.out.print("Giải nghĩa tiếng Việt: ");
            String word_explain_ = sc.nextLine();
            Word newwords = new Word(word_target_, word_explain_);
            addWord(newwords); // da sap xep
            System.out.print("\n");
        }
    }
}
