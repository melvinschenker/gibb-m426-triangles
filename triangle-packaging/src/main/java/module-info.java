module com.example.trianglepackaging {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.trianglepackaging to javafx.fxml;
    exports com.example.trianglepackaging;
    exports com.example.trianglepackaging.controller;
    opens com.example.trianglepackaging.controller to javafx.fxml;
}