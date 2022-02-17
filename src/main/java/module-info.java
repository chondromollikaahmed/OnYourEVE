module com.ca.onyoureve {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires com.jfoenix;
    requires javafx.web;
    requires mail;
    opens com.ca.onyoureve to javafx.fxml;
    exports com.ca.onyoureve;
    exports com.ca.onyoureve.trialClass;
    opens com.ca.onyoureve.trialClass to javafx.fxml;
}