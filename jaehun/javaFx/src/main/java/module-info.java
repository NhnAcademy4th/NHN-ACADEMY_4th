module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.course2.chapter3 to javafx.fxml;
    exports com.course2.chapter3;

    opens com.course2.chapter4 to javafx.fxml;
    exports com.course2.chapter4;

    opens com.course2.chapter6 to javafx.fxml;
    exports com.course2.chapter6;


}