module yourmodule {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaproject2023 to javafx.fxml;
    exports com.example.javaproject2023;
}