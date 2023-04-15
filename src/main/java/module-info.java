module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    //requires rt;


    opens assignment.dictionary to javafx.fxml;
    exports assignment.dictionary;
}