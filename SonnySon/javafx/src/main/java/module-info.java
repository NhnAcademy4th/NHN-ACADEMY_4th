module com.nhnacademy.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nhnacademy.javafx to javafx.fxml;
    exports com.nhnacademy.javafx;
}