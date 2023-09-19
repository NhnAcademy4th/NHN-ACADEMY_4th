module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.course2.chapter3 to javafx.fxml;
    exports com.course2.chapter3;
}