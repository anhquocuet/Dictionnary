package com.example.javaproject2023;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        searchWordBt.setOnAction(actionEvent -> {
            loadComponent("/view/SearchWordGui.fxml");
        });
        addWordBt.setOnAction(actionEvent -> {
            loadComponent("/view/AddWordGui.fxml");
        });

        translateBt.setOnAction(actionEvent -> {
            loadComponent("/view/TranslateGui.fxml");
        });

        // đưa ra tác dụng của nghe sửa xoá
        tip1.setShowDelay(javafx.util.Duration.millis(500));
        tip2.setShowDelay(javafx.util.Duration.millis(500));
        tip3.setShowDelay(javafx.util.Duration.millis(500));
        loadComponent("/view/SearchWordGui.fxml");

        closeBt.setOnMouseClicked(event -> System.exit(0));
    }

    private void replaceContainerContent(Node newContent) {
        container.getChildren().clear();
        container.getChildren().setAll(newContent);
    }
    private void displayComponent(Node component) {
        // Xóa tất cả các thành phần con hiện tại của container và thêm thành phần mới
        replaceContainerContent(component);
    }


    @FXML
    private Tooltip tip1, tip2, tip3;

    @FXML
    private Button addWordBt, translateBt, searchWordBt, closeBt;

    @FXML
    private AnchorPane container;

    @FXML
    private void loadComponent(String fxmlPath) {
        try {
            AnchorPane loadComponent = FXMLLoader.load(getClass().getResource(fxmlPath));
            displayComponent(loadComponent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
