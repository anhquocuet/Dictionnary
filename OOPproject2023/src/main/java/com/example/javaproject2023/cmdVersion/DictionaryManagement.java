package com.example.javaproject2023.cmdVersion;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

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
    public void updateWordFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập từ bạn muốn sửa: ");
        String word_target = sc.nextLine();
        System.out.print("Nhập nghĩa tiếng việt: ");
        String update_word_explain = sc.nextLine();
        updateWord(word_target, update_word_explain);
    }
    /**
     * in du lieu tu txt.
     */

    public void insertFromFile(Dictionary dictionary, String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String englishWord = bufferedReader.readLine();
            englishWord = englishWord.replace("|", "");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Word word = new Word();
                word.setWord_target(englishWord.trim());
                String meaning = line + "\n";
                while ((line = bufferedReader.readLine()) != null)
                    if (!line.startsWith("|")) meaning += line + "\n";
                    else {
                        englishWord = line.replace("|", "");
                        break;
                    }
                word.setWord_explain(meaning.trim());
                dictionary.getWords().add(word);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occur with file: " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }

    public void dictionaryLookup(String englishWord) {
        String s = searchWord(englishWord);
        System.out.print(s);
    }

    public void dictionaryImportFromFile(String path) {
        try {
            File infile = new File(path);
            Scanner sc = new Scanner(infile);
            while (sc.hasNextLine()) {
                String lineText = sc.nextLine();
                String[] x = lineText.split("\t");
                if (x.length == 2) {
                    String wordTarget = x[0];
                    String wordExplain = x[1];
                    Word word = new Word(wordTarget, wordExplain);
                    addWord(word);
                }
            }
            sc.close();
            System.out.println("Đã nhập danh sách từ vựng từ tệp thành công...");
        } catch (FileNotFoundException a) {
            System.out.println("Không tìm thấy file: " + a.getMessage());
        }
    }

    public void dictionaryExportToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for (int i=0; i<words.size();i++) {
                String line = "|" + words.get(i).getWord_target() + "\n" + words.get(i).getWord_explain();
                writer.write(line);
            }
            writer.close();
            System.out.println("Xuất file thành công.\n");
        } catch (IOException a) {
            System.out.println("Xuất file lỗi: " + a.getMessage());
        }
    }
}
