module com.example.ceaserfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ceaserfx to javafx.fxml;
    exports com.example.ceaserfx;
}