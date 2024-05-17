module com.example.gochat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    requires org.controlsfx.controls;
    requires de.jensd.fx.glyphs.fontawesome;
    requires jbcrypt;

    opens com.example.gochat to javafx.fxml;
    exports com.example.gochat;
}