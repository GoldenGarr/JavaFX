module com.example.firstjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.firstjavafx to javafx.fxml;
    exports com.example.firstjavafx;
    exports com.example.firstjavafx.controllers;
    opens com.example.firstjavafx.controllers to javafx.fxml;
}