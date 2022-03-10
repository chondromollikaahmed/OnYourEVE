module com.ca.onyoureve {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.web;
    requires com.jfoenix;
    requires mail;
    opens com.ca.onyoureve to javafx.fxml;
    exports com.ca.onyoureve;
}