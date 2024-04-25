module com.example.gochat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.example.gochat to javafx.fxml;
    exports com.example.gochat;
}