//package com.example.javaproject2023;
//
//public class AddWordController {
//}
package com.example.javaproject2023;

import com.example.javaproject2023.cmdVersion.Dictionary;
import com.example.javaproject2023.cmdVersion.DictionaryManagement;
import com.example.javaproject2023.cmdVersion.Word;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddWordController implements Initializable {
    private Dictionary dic = new Dictionary();
    private DictionaryManagement dM = new DictionaryManagement();
    private final String filePath = "D:\\IdeaProjects\\JavaProject2023\\src\\main\\resources\\dictionaries.txt";

    @Override
    public void initialize(URL url1, ResourceBundle rs) {
        dM.insertFromFile(dic, filePath);

        addBt.setDisable(true);

        wordTarget_Input.setOnKeyTyped(event -> {
            boolean isEitherBlank = explanation_Input.getText().isBlank() || wordTarget_Input.getText().isBlank();
            addBt.setDisable(isEitherBlank);
        });

        explanation_Input.setOnKeyTyped(event -> {
            boolean isEitherBlank = explanation_Input.getText().isBlank() || wordTarget_Input.getText().isBlank();
            addBt.setDisable(isEitherBlank);
        });


//        successAlert.setVisible(false);
    }

    @FXML
    private void handleClickAddButton() {
        String englishWord = wordTarget_Input.getText().trim();
        String meaning = explanation_Input.getText().trim();
        Word word = new Word(englishWord, meaning);
        Dictionary.addWord(word);
        // resetInput
        wordTarget_Input.setText("");
        explanation_Input.setText("");
    }



    @FXML
    private Button addBt;

    @FXML
    private TextField wordTarget_Input;

    @FXML
    private TextArea explanation_Input;

    @FXML
    private Label success_Alert;
}